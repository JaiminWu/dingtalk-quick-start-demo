package com.pojo;

import com.util.RandomStringUtil;
import org.joda.time.DateTime;

public class CustomerVisit {

    private String customerVisitId;

    private String visitTitle;

    private String accountName;

    private String contactName;

    private String dueTime;

    private String address;

    private String visitSummary;

    //钉Talk userId
    private String userId;

    //钉Talk userName
    private String userName;

    private String status;

    public String getCustomerVisitId() {
        return customerVisitId;
    }

    public void setCustomerVisitId(String customerVisitId) {
        this.customerVisitId = customerVisitId;
    }

    public String getVisitTitle() {
        return visitTitle;
    }

    public void setVisitTitle(String visitTitle) {
        this.visitTitle = visitTitle;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVisitSummary() {
        return visitSummary;
    }

    public void setVisitSummary(String visitSummary) {
        this.visitSummary = visitSummary;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerVisit testObject() {
        CustomerVisit customerVisit = new CustomerVisit();
//        customerVisit.customerVisitId = "id"+ RandomStringUtil.getRandomString(15);
        customerVisit.accountName = "Test Account";
        customerVisit.address = "Test Address";
        customerVisit.contactName = "Test Contact Name";
        customerVisit.dueTime = new DateTime(2020, 12, 5, 0, 0, 0).toString("MM/dd/yyyy HH:mm");
        customerVisit.userId = "id" + RandomStringUtil.getRandomString(15);
        customerVisit.userName = "Test User";
        customerVisit.visitSummary = "Test summary";
        customerVisit.visitTitle = "Test Title";
        return customerVisit;
    }

}
