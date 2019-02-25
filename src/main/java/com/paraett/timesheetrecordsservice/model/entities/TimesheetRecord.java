package com.paraett.timesheetrecordsservice.model.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "timesheet_record_tbl")
public class TimesheetRecord {
    @Id
    @Column(name = "timesheet_record_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column
    private Date date;

    @Column
    private Integer noHours;

    @Column
    private Boolean overtime;

    public TimesheetRecord() {
    }
}
