package com.limeus.expenseservice.service;


import com.limeus.commonlib.jwt.JwtClaimsManager;
import com.limeus.expenseservice.dto.CreateExpenseRequest;
import com.limeus.expenseservice.dto.ExpenseResponse;
import com.limeus.expenseservice.dto.UpdateExpenseRequest;
import com.limeus.expenseservice.entity.ExpenseEntity;
import com.limeus.expenseservice.mapper.ExpenseMapper;
import com.limeus.expenseservice.mapper.UpdateExpenseMapper;
import com.limeus.expenseservice.repository.ExpenseRepository;
import com.limeus.expenseservice.utils.specification.ExpenseFilter;
import com.limeus.expenseservice.utils.specification.ExpenseSpecifications;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final UpdateExpenseMapper updateExpenseMapper;
    private final JwtClaimsManager jwtClaimsManager;

    private final static UUID USER_ID = UUID.randomUUID(); //ЗАГЛУШКА

    private static final String EXPENSE_NOT_FOUND_MESSAGE = "Expense not exists";

    @Override
    public ExpenseResponse createExpense(CreateExpenseRequest createExpenseRequest) {
        ExpenseEntity expense = expenseMapper.toEntity(createExpenseRequest);
//        expense.setUserId(UUID.fromString(jwtClaimsManager.extractUserId()));
        expense.setUserId(USER_ID); //ЗАГЛУШКА
        ExpenseEntity saved = expenseRepository.save(expense);
        return expenseMapper.toResponse(saved);
    }

    @Override
    public void deleteExpense(UUID id) {
        ExpenseEntity entity = getExpenseOrThrow(id);
        expenseRepository.deleteById(id);
    }

    @Override
    public ExpenseResponse getExpense(UUID id) {
        return expenseMapper.toResponse(
                getExpenseOrThrow(id)
        );
    }

    @Override
    @Transactional
    public ExpenseResponse updateExpense(UUID id, UpdateExpenseRequest updateExpenseRequest) {
        ExpenseEntity currentExpense = getExpenseOrThrow(id);
        updateExpenseMapper.updateEntity(updateExpenseRequest, currentExpense); // обновляет currentExpense
        return expenseMapper.toResponse(currentExpense);
    }

    @Override
    public List<ExpenseResponse> getFamilyExpenses(UUID familyId, OffsetDateTime fromDate, OffsetDateTime toDate, String category) {
        //        UUID userId = UUID.fromString(jwtClaimsManager.extractUserId());

        ExpenseFilter filter = ExpenseFilter.builder()
//                .userId(userId)
                .userId(USER_ID)
                .familyId(familyId)
                .fromDate(fromDate)
                .toDate(toDate)
                .category(category)
                .build();
        Specification<ExpenseEntity> spec = ExpenseSpecifications.byFilter(filter);

        List<ExpenseEntity> matchedExpenses = expenseRepository.findAll(spec);

        return matchedExpenses.stream()
                .map(expenseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseResponse> getAllExpenses(OffsetDateTime fromDate, OffsetDateTime toDate, String category) {
        ExpenseFilter filter = ExpenseFilter.builder()
                .fromDate(fromDate)
                .toDate(toDate)
                .category(category)
                .build();
        Specification<ExpenseEntity> spec = ExpenseSpecifications.byFilter(filter);

        List<ExpenseEntity> matchedExpenses = expenseRepository.findAll(spec);

        return matchedExpenses.stream()
                .map(expenseMapper::toResponse)
                .collect(Collectors.toList());

    }

    @Override
    public List<ExpenseResponse> getMyFamilyExpenses(UUID familyId, OffsetDateTime fromDate, OffsetDateTime toDate, String category) {
//        UUID userId = UUID.fromString(jwtClaimsManager.extractUserId());

        ExpenseFilter filter = ExpenseFilter.builder()
                //                .userId(userId)
                .userId(USER_ID)
                .familyId(familyId)
                .fromDate(fromDate)
                .toDate(toDate)
                .category(category)
                .build();
        Specification<ExpenseEntity> spec = ExpenseSpecifications.byFilter(filter);

        List<ExpenseEntity> matchedExpenses = expenseRepository.findAll(spec);

        return matchedExpenses.stream()
                .map(expenseMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExpenseResponse> getMyPersonalExpenses(OffsetDateTime fromDate, OffsetDateTime toDate, String category) {
//        UUID userId = UUID.fromString(jwtClaimsManager.extractUserId());

        ExpenseFilter filter = ExpenseFilter.builder()
                //                .userId(userId)
                .userId(USER_ID)
                .familyId(null)
                .fromDate(fromDate)
                .toDate(toDate)
                .category(category)
                .build();
        Specification<ExpenseEntity> spec = ExpenseSpecifications.byPersonalExpenses(filter);

        List<ExpenseEntity> matchedExpenses = expenseRepository.findAll(spec);

        return matchedExpenses.stream()
                .map(expenseMapper::toResponse)
                .collect(Collectors.toList());
    }

    private ExpenseEntity getExpenseOrThrow(UUID id) {
        return expenseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, EXPENSE_NOT_FOUND_MESSAGE)
        );
    }
}
