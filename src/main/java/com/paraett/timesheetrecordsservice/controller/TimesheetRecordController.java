package com.paraett.timesheetrecordsservice.controller;

import com.paraett.timesheetrecordsservice.model.entities.TimesheetRecord;
import com.paraett.timesheetrecordsservice.service.TimesheetRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/timesheet-records")
public class TimesheetRecordController {

    private TimesheetRecordService timesheetRecordService;

    public TimesheetRecordController(TimesheetRecordService timesheetRecordService) {
        this.timesheetRecordService = timesheetRecordService;
    }

    @GetMapping("")
    public ResponseEntity<List<TimesheetRecord>> getAllTimesheetRecords(@RequestParam(required = false) Long companyId, @RequestParam(required = false) Long projectId,
                                                                @RequestParam(required = false) Long userId,
                                                                @RequestParam(required = false) Date minDate, @RequestParam(required = false) Date maxDate) {
        List<TimesheetRecord> timesheetRecords = timesheetRecordService.getAllTimesheetRecords(companyId, projectId, userId, minDate, maxDate);

        return ResponseEntity.ok(timesheetRecords);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimesheetRecord> getFreeTimesheetRecord(@PathVariable Long id) {
        TimesheetRecord timesheetRecord = timesheetRecordService.getFreeTimesheetRecord(id);

        return ResponseEntity.ok(timesheetRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTimesheetRecord(@PathVariable Long id) {
        timesheetRecordService.deleteTimesheetRecord(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Object> createTimesheetRecords(@RequestBody List<TimesheetRecord> timesheetRecords) {
        List<TimesheetRecord> createdTimesheetRecords = timesheetRecordService.createTimesheetRecords(timesheetRecords);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().queryParam("companyId", createdTimesheetRecords.get(0).getCompanyId()).queryParam("userId", createdTimesheetRecords.get(0).getUserId()).build()
                .toUri();

        return ResponseEntity.created(location).body(createdTimesheetRecords);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimesheetRecord> updateTimesheetRecord(@PathVariable Long id, @RequestBody TimesheetRecord timesheetRecord) {
        TimesheetRecord updatedTimesheetRecord = timesheetRecordService.updateTimesheetRecord(id, timesheetRecord);

        return ResponseEntity.accepted().body(updatedTimesheetRecord);
    }
}
