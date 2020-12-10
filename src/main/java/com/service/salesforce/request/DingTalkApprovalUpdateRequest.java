package com.service.salesforce.request;

public class DingTalkApprovalUpdateRequest extends BaseSalesforceRequest{
    private String status;
    private String comment;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return "{\"Status__c\":\"" + status +
                "\", \"Approver_Comment__c\":\"" + comment +
                "\"}";
    }
}
