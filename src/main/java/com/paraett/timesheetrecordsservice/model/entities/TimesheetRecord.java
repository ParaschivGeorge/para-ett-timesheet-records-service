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

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name="company_id")
    private Long companyId;

    @Column(name="project_id")
    private Long projectId;

    @Column
    private Date date;

    @Column
    private Integer noHours;

    @Column
    private Boolean overtime;

    public TimesheetRecord() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNoHours() {
        return noHours;
    }

    public void setNoHours(Integer noHours) {
        this.noHours = noHours;
    }

    public Boolean getOvertime() {
        return overtime;
    }

    public void setOvertime(Boolean overtime) {
        this.overtime = overtime;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
}
