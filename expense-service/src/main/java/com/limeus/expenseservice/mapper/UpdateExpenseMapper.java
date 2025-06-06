package com.limeus.expenseservice.mapper;

import com.limeus.expenseservice.dto.UpdateExpenseRequest;
import com.limeus.expenseservice.entity.ExpenseEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface UpdateExpenseMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "familyId", ignore = true)
    void updateEntity(UpdateExpenseRequest updateExpenseRequest, @MappingTarget ExpenseEntity targetExpense);
}