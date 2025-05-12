package com.limeus.expenseservice.service;


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

    private static final String EXPENSE_NOT_FOUND_MESSAGE = "Expense not exists";

    @Override
    public ExpenseResponse createExpense(CreateExpenseRequest createExpenseRequest) {
        ExpenseEntity expense = expenseMapper.toEntity(createExpenseRequest);
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
    public List<ExpenseResponse> getExpenses(String expenseScope, OffsetDateTime fromDate, OffsetDateTime toDate, String category) {

        /// ///////////////////////////
        // Заглушка для fake данных
        UUID fakeUserId = UUID.fromString("11111111-1111-1111-1111-111111111111");
        UUID fakeFamilyId = UUID.fromString("22222222-2222-2222-2222-222222222222");

        // Логика выбора scope
        if (expenseScope == null || expenseScope.equals("user")) {
            expenseScope = "user";  // По умолчанию "user"
        } else if (expenseScope.equals("family")) {
            expenseScope = "family";
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid expense scope: " + expenseScope);
        }
        /// ///////////////////////////

        ExpenseFilter filter = ExpenseFilter.builder()
                .expenseScope(expenseScope)
                .fromDate(fromDate)
                .toDate(toDate)
                .category(category)
                .build();

//        Specification<ExpenseEntity> spec = ExpenseSpecifications.byFilter(filter);
        // ЭТО - ВЕРНУТЬ

        /// ///////////////////////////
        Specification<ExpenseEntity> spec;
        if ("user".equals(expenseScope)) {
            // Заглушка для user
            spec = ExpenseSpecifications.byUserId(fakeUserId, filter);  // Передаем fakeUserId для тестов
        } else {
            // Заглушка для family
            spec = ExpenseSpecifications.byFamilyId(fakeFamilyId, filter);  // Передаем fakeFamilyId для тестов
        }
        /// ///////////////////////////

        List<ExpenseEntity> matchedExpenses = expenseRepository.findAll(spec);

        return matchedExpenses.stream()
                .map(expenseMapper::toResponse)
                .collect(Collectors.toList());

    }

    @Override
    @Transactional
    public ExpenseResponse updateExpense(UUID id, UpdateExpenseRequest updateExpenseRequest) {
        ExpenseEntity currentExpense = getExpenseOrThrow(id);
        updateExpenseMapper.updateEntity(updateExpenseRequest, currentExpense); // обновляет currentExpense
        return expenseMapper.toResponse(currentExpense);
    }

    private ExpenseEntity getExpenseOrThrow(UUID id) {
        return expenseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, EXPENSE_NOT_FOUND_MESSAGE)
        );
    }
}
