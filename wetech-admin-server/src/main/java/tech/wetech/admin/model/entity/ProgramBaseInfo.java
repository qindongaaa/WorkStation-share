package tech.wetech.admin.model.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "program_baseinfo")
@Data
public class ProgramBaseInfo {
    /**
     * 编号
     */
    @Id
    private Long id;
    /**
     * 项目名
     */
    private String programname;
    /**
     * 项目简介
     */
    private String programbrief;
    /**
     * 项目金额
     */
    private Integer programquota;
    /**
     * 项目经理
     */
    private String programmag;
    /**
     * 开始时间
     */
    private Date starttime;
    /**
     * 工期
     */
    private Integer programduration;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 创建者id
     */
    private Long createrid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getProgramquota() {
        return programquota;
    }

    public void setProgramquota(Integer programquota) {
        this.programquota = programquota;
    }

    public String getProgrammag() {
        return programmag;
    }

    public void setProgrammag(String programmag) {
        this.programmag = programmag;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getProgramduration() {
        return programduration;
    }

    public void setProgramduration(Integer programduration) {
        this.programduration = programduration;
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
}
