package com.service.salesforce.request;

public abstract class BaseSalesforceRequest implements SalesforceRequest{

    private String sObjectName;
    private String sObjectId;

    public String getsObjectName() {
        return sObjectName;
    }

    public void setsObjectName(String sObjectName) {
        this.sObjectName = sObjectName;
    }

    public String getsObjectId() {
        return sObjectId;
    }

    public void setsObjectId(String sObjectId) {
        this.sObjectId = sObjectId;
    }

    public String getResourceUrl(){
        return "/" + sObjectName + "/" + sObjectId;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
