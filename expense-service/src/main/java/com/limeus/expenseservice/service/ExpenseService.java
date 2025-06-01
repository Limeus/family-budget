package com.limeus.expenseservice.service;

import com.limeus.expenseservice.dto.CreateExpenseRequest;
import com.limeus.expenseservice.dto.ExpenseResponse;
import com.limeus.expenseservice.dto.UpdateExpenseRequest;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public interface ExpenseService {
    ExpenseResponse createExpense(CreateExpenseRequest createExpenseRequest);

    void deleteExpense(UUID id);

    ExpenseResponse getExpense(UUID id);

//    List<ExpenseResponse> getExpenses(String expenseScope, OffsetDateTime fromDate, OffsetDateTime toDate, String category);

    ExpenseResponse updateExpense(UUID id, UpdateExpenseRequest updateExpenseRequest);

    List<ExpenseResponse> getFamilyExpenses(UUID familyId, OffsetDateTime fromDate, OffsetDateTime toDate, String category);

    List<ExpenseResponse> getAllExpenses(OffsetDateTime fromDate, OffsetDateTime toDate, String category);

    List<ExpenseResponse> getMyFamilyExpenses(UUID familyId, OffsetDateTime fromDate, OffsetDateTime toDate, String category);

    List<ExpenseResponse> getMyPersonalExpenses(OffsetDateTime fromDate, OffsetDateTime toDate, String category);
}
