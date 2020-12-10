package com.pojo;

import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;

import java.util.List;

public class ProcessRequest {
    private String processCode;

    private String originatorUserId;

    private Long deptId;

    private String approvers;

    private List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues;

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getOriginatorUserId() {
        return originatorUserId;
    }

    public void setOriginatorUserId(String originatorUserId) {
        this.originatorUserId = originatorUserId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getApprovers() {
        return approvers;
    }

    public void setApprovers(String approvers) {
        this.approvers = approvers;
    }

    public List<OapiProcessinstanceCreateRequest.FormComponentValueVo> getFormComponentValues() {
        return formComponentValues;
    }

    public void setFormComponentValues(List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues) {
        this.formComponentValues = formComponentValues;
    }
}
