package tech.wetech.admin.model.dto;

import java.util.Date;

public class ProgramDTO {
    private String programname;
    private String programbrief;
    private String programmag;
    private Integer programquota;
    private Integer programduration;
    private Date programstarttime;
    private Long createrid;
    private Date createtime;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Long getCreaterid() {
        return createrid;
    }

    public void setCreaterid(Long createrid) {
        this.createrid = createrid;
    }

    public String getProgramname() {
        return programname;
    }

    public void setProgramname(String programname) {
        this.programname = programname;
    }

    public String getProgrambrief() {
        return programbrief;
    }

    public void setProgrambrief(String programbrief) {
        this.programbrief = programbrief;
    }

    public String getProgrammag() {
        return programmag;
    }

    public void setProgrammag(String programmag) {
        this.programmag = programmag;
    }

    public Integer getProgramquota() {
        return programquota;
    }

    public void setProgramquota(Integer programquota) {
        this.programquota = programquota;
    }

    public Integer getProgramduration() {
        return programduration;
    }

    public void setProgramduration(Integer programduration) {
        this.programduration = programduration;
    }

    public Date getProgramstarttime() {
        return programstarttime;
    }

    public void setProgramstarttime(Date programstarttime) {
        this.programstarttime = programstarttime;
    }
}
