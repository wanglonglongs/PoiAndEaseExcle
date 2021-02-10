package com.study;

import java.util.Date;

/**
 * @ClassName EntityLog
 * @Description: TODO
 * @Author wanglonglong
 * @Date 2021/2/10
 * @Version V1.0
 **/
public class EntityLog {
    private Integer id;

    private Integer stuId;

    private String xingxi;

    private Date createDate;

    private String relust;

    private String type;

    @Override
    public String toString() {
        return "EntityLog{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", xingxi='" + xingxi + '\'' +
                ", createDate=" + createDate +
                ", relust='" + relust + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getXingxi() {
        return xingxi;
    }

    public void setXingxi(String xingxi) {
        this.xingxi = xingxi;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRelust() {
        return relust;
    }

    public void setRelust(String relust) {
        this.relust = relust;
    }
}
