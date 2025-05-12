package com.limeus.expenseservice.mapper;

import com.limeus.expenseservice.dto.CreateExpenseRequest;
import com.limeus.expenseservice.dto.ExpenseResponse;
import com.limeus.expenseservice.entity.ExpenseEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    ExpenseResponse toResponse(ExpenseEntity expenseEntity);
    ExpenseEntity toEntity(ExpenseResponse expenseResponse);
    ExpenseEntity toEntity(CreateExpenseRequest createExpenseRequest);

}
