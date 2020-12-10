package com.service.salesforce.request;

public class GetSalesforceApprovalIDRequest extends BaseSalesforceRequest{
    private String processId;

    private String salesforceApprovalId;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getSalesforceApprovalId() {
        return salesforceApprovalId;
    }

    public void setSalesforceApprovalId(String salesforceApprovalId) {
        this.salesforceApprovalId = salesforceApprovalId;
    }

    @Override
    public String getResourceUrl(){
        return "DingTalkApprovalResource" + "/" + processId;
    }

}
