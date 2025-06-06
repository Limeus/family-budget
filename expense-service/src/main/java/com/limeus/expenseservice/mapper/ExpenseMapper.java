package com.limeus.expenseservice.mapper;

import com.limeus.expenseservice.dto.CreateExpenseRequest;
import com.limeus.expenseservice.dto.ExpenseResponse;
import com.limeus.expenseservice.entity.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExpenseMapper {
    ExpenseResponse toResponse(ExpenseEntity expenseEntity);
    ExpenseEntity toEntity(ExpenseResponse expenseResponse);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    ExpenseEntity toEntity(CreateExpenseRequest createExpenseRequest);

}
