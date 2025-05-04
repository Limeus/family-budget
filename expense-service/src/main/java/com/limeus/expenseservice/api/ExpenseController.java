package com.limeus.expenseservice.api;

import com.limeus.expenseservice.dto.CreateExpenseRequest;
import com.limeus.expenseservice.dto.ExpenseResponse;
import com.limeus.expenseservice.dto.UpdateExpenseRequest;
import com.limeus.expenseservice.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ExpenseController implements ExpenseApi{
    private final ExpenseService expenseService;

    @Override
    public ResponseEntity<ExpenseResponse> createExpense(CreateExpenseRequest createExpenseRequest) {
        ExpenseResponse createdExpense = expenseService.createExpense(createExpenseRequest);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdExpense.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdExpense);
    }

    @Override
    public ResponseEntity<Void> deleteExpense(UUID id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ExpenseResponse> getExpenseById(UUID id) {
        return ResponseEntity.ok(expenseService.getExpense(id));
    }

    @Override
    public ResponseEntity<List<ExpenseResponse>> getExpenses(String expenseScope, OffsetDateTime fromDate, OffsetDateTime toDate, String category) {
        return ResponseEntity.ok(expenseService.getExpenses(expenseScope, fromDate, toDate, category));
    }


    @Override
    public ResponseEntity<ExpenseResponse> updateExpense(UUID id, UpdateExpenseRequest updateExpenseRequest) {
        return ResponseEntity.ok(expenseService.updateExpense(id, updateExpenseRequest));
    }
}
