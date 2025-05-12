package com.limeus.expenseservice.utils.specification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseFilter {
    private String expenseScope;
    private UUID userId;        // Идентификатор пользователя (если выбираются расходы по пользователю)
    private UUID familyId;
    private OffsetDateTime fromDate;
    private OffsetDateTime toDate;
    private String category;
}