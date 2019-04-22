package com.paraett.timesheetrecordsservice.repository;

import com.paraett.timesheetrecordsservice.model.entities.TimesheetRecord;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimesheetRecordSpecifications {
    public static Specification<TimesheetRecord> findAllFiltered(Long companyId, Long projectId, Long userId, Date minDate, Date maxDate) {
        return new Specification<TimesheetRecord>() {
            @Override
            public Predicate toPredicate(Root<TimesheetRecord> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                final List<Predicate> predicateList = new ArrayList<>();

                if (companyId != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("companyId"), companyId));
                }

                if (projectId != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("projectId"), projectId));
                }

                if (userId != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("userId"), userId));
                }

                if (minDate != null) {
                    predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("date"), minDate));
                }

                if (maxDate != null) {
                    predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("date"), maxDate));
                }
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
