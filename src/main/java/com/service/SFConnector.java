package com.service;

import com.pojo.CustomerVisit;
import com.util.RandomStringUtil;

public class SFConnector {

    public static CustomerVisit testQueryCustomerVisit(String id) {
        CustomerVisit customerVisit = new CustomerVisit().testObject();
        customerVisit.setCustomerVisitId(id);
        return customerVisit;
    }

    public static CustomerVisit testCreateCustomerVisit(CustomerVisit customerVisit) {
        customerVisit.setCustomerVisitId("id" + RandomStringUtil.getRandomString(15));
        return customerVisit;
    }

}
