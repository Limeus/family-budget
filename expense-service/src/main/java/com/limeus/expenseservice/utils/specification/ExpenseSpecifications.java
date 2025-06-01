package com.limeus.expenseservice.utils.specification;

import com.limeus.expenseservice.entity.ExpenseEntity;
import jakarta.persistence.criteria.Predicate;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ExpenseSpecifications {

    public static Specification<ExpenseEntity> byPersonalExpenses(ExpenseFilter filter) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            predicate = cb.and(predicate, cb.isNull(root.get("familyId"))); // только персональные

            if (filter.getUserId() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("userId"), filter.getUserId()));
            }
            if (filter.getFromDate() != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("date"), filter.getFromDate()));
            }
            if (filter.getToDate() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("date"), filter.getToDate()));
            }
            if (filter.getCategory() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("category"), filter.getCategory()));
            }

            return predicate;
        };
    }

    public static Specification<ExpenseEntity> byFilter(ExpenseFilter filter) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

            if (filter.getUserId() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("userId"), filter.getUserId()));
            }
            if (filter.getFamilyId() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("familyId"), filter.getFamilyId()));
            }
            if (filter.getFromDate() != null) {
                predicate = cb.and(predicate, cb.greaterThanOrEqualTo(root.get("date"), filter.getFromDate()));
            }
            if (filter.getToDate() != null) {
                predicate = cb.and(predicate, cb.lessThanOrEqualTo(root.get("date"), filter.getToDate()));
            }
            if (filter.getCategory() != null) {
                predicate = cb.and(predicate, cb.equal(root.get("category"), filter.getCategory()));
            }

            return predicate;
        };
    }
}
