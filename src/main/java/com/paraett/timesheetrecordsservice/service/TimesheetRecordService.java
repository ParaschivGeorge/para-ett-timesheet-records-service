package com.paraett.timesheetrecordsservice.service;

import com.paraett.timesheetrecordsservice.exception.NotFoundException;
import com.paraett.timesheetrecordsservice.model.entities.TimesheetRecord;
import com.paraett.timesheetrecordsservice.repository.TimesheetRecordRepository;
import com.paraett.timesheetrecordsservice.repository.TimesheetRecordSpecifications;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetRecordService {

    private TimesheetRecordRepository timesheetRecordRepository;

    public List<TimesheetRecord> getAllTimesheetRecords(Long companyId, Long projectId, Long userId, Date minDate, Date maxDate) {
        return timesheetRecordRepository.findAll(TimesheetRecordSpecifications.findAllFiltered(companyId, projectId, userId, minDate, maxDate));
    }

    public TimesheetRecord getFreeTimesheetRecord(Long id) {
        Optional<TimesheetRecord> optionalTimesheetRecord = timesheetRecordRepository.findById(id);
        if (optionalTimesheetRecord.isPresent()) {
            return optionalTimesheetRecord.get();
        }
        throw new NotFoundException("id: " + id);
    }

    public void deleteTimesheetRecord(Long id) {
        Optional<TimesheetRecord> optionalTimesheetRecord = timesheetRecordRepository.findById(id);
        if (optionalTimesheetRecord.isPresent()) {
            timesheetRecordRepository.deleteById(id);
        }
        throw new NotFoundException("id: " + id);
    }

    public List<TimesheetRecord> createTimesheetRecords(List<TimesheetRecord> timesheetRecords) {
        return timesheetRecordRepository.saveAll(timesheetRecords);
    }

    public TimesheetRecord updateTimesheetRecord(Long id, TimesheetRecord timesheetRecord) {
        Optional<TimesheetRecord> optionalTimesheetRecord = timesheetRecordRepository.findById(id);
        if (optionalTimesheetRecord.isPresent()) {
            timesheetRecord.setId(id);
            timesheetRecordRepository.save(timesheetRecord);
        }
        throw new NotFoundException("id: " + id);
    }
}
