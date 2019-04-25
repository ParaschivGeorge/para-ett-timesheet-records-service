package com.paraett.timesheetrecordsservice.repository;

import com.paraett.timesheetrecordsservice.model.entities.TimesheetRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TimesheetRecordRepository extends JpaRepository<TimesheetRecord, Long>, JpaSpecificationExecutor<TimesheetRecord> {
    @Transactional
    @Modifying
    void deleteAllByCompanyId(Long companyId);
    @Transactional
    @Modifying
    void deleteAllByUserId(Long userId);
}
