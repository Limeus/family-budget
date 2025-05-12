package com.limeus.expenseservice.utils.specification;

import com.limeus.expenseservice.entity.ExpenseEntity;
import jakarta.persistence.criteria.Predicate;
import org.apache.coyote.BadRequestException;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class ExpenseSpecifications {

    /// ///////////////////////////////////////// ЗАГЛУШКА
    public static Specification<ExpenseEntity> byUserId(UUID userId, ExpenseFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate userPredicate = criteriaBuilder.equal(root.get("userId"), userId);
            return criteriaBuilder.and(userPredicate, byFilter(filter).toPredicate(root, query, criteriaBuilder));
        };
    }

    public static Specification<ExpenseEntity> byFamilyId(UUID familyId, ExpenseFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate familyPredicate = criteriaBuilder.equal(root.get("familyId"), familyId);
            return criteriaBuilder.and(familyPredicate, byFilter(filter).toPredicate(root, query, criteriaBuilder));
        };
    }
    /// /////////////////////////////////////////

    public static Specification<ExpenseEntity> byFilter(ExpenseFilter filter) {
        return (root, query, cb) -> {
            Predicate predicate = cb.conjunction();

//            if (filter.getExpenseScope() != null) {
//                predicate = cb.and(predicate, cb.equal(root.get("expenseScope"), filter.getExpenseScope()));
//            }
            /// ///////////////////////////////////////////
            if ("user".equals(filter.getExpenseScope())) {
                predicate = cb.and(predicate, cb.equal(root.get("userId"), filter.getUserId()));
            } else if ("family".equals(filter.getExpenseScope())) {
                predicate = cb.and(predicate, cb.equal(root.get("familyId"), filter.getFamilyId()));
            } else {
                try {
                    throw new BadRequestException("Invalid expenseScope value: " + filter.getExpenseScope());
                } catch (BadRequestException e) {
                    throw new RuntimeException(e);
                }
            }
            /// /////////////////////////////////////////////

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
