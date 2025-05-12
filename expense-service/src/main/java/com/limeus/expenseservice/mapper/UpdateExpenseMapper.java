package com.limeus.expenseservice.mapper;

import com.limeus.expenseservice.dto.UpdateExpenseRequest;
import com.limeus.expenseservice.entity.ExpenseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UpdateExpenseMapper {
    void updateEntity(UpdateExpenseRequest updateExpenseRequest, @MappingTarget ExpenseEntity targetExpense);
}