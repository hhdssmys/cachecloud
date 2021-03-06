package com.sohu.cache.entity;

import com.sohu.cache.constant.AppAuditType;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yijunzhang
 */
@Data
public class AppAudit {

    private long id;

    private long appId;

    private long userId;

    private long operateId;

    private String userName;

    /**
     * 申请类型:AppAuditType
     */
    private int type;

    /**
     * 预留参数1
     */
    private String param1;
    /**
     * 预留参数2
     */
    private String param2;
    /**
     * 预留参数3
     */
    private String param3;

    /**
     * 申请描述
     */
    private String info;

    /**
     * 0:等待审批; 1:审批通过; -1:驳回
     */
    private int status;

    private Date createTime;

    private Date modifyTime;

    /**
     * 驳回原因
     */
    private String refuseReason;

    /**
     * 任务ID
     */
    private long taskId;

    private AppDesc appDesc;

    private AppAuditLog appAuditLog;

    public Date getCreateTime() {
        if (createTime != null) {
            return (Date) createTime.clone();
        }
        return null;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = (Date) createTime.clone();
    }

    public Date getModifyTime() {
        if (modifyTime == null) {
            return null;
        }
        return (Date) modifyTime.clone();
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = (Date) modifyTime.clone();
    }

    public String getTypeDesc() {
        if (AppAuditType.getAppAuditType(type) != null) {
            return AppAuditType.getAppAuditType(type).getInfo();
        }
        return "";
    }

    public String getStatusDesc() {
        //        0:等待审批; 1:审批通过; -1:驳回
        if (status == 0) {
            return "等待审批";
        } else if (status == 1) {
            return "审批通过";
        } else if (status == -1) {
            return "驳回";
        } else {
            return status + "";
        }
    }

    public String getCreateTimeFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (createTime != null) {
            return sdf.format(createTime);
        }
        return "";
    }

}
