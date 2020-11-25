package com.controller;

import com.pojo.CustomerVisit;
import com.service.SFConnector;
import com.util.ServiceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectorController {

    private static final Logger bizLogger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/connector/query", method = RequestMethod.GET)
    public ServiceResult whenLoaded(@RequestParam(value = "id") String id) {
        return ServiceResult.success(SFConnector.testQueryCustomerVisit(id));
    }

    @RequestMapping(value = "/connector/submit", method = RequestMethod.POST)
    public ServiceResult whenSubmit() {
        CustomerVisit customerVisit = new CustomerVisit().testObject();
//        customerVisit = customerVisit.testObject();
        return ServiceResult.success(SFConnector.testCreateCustomerVisit(customerVisit));
    }

    @RequestMapping(value = "/connector/validate", method = RequestMethod.GET)
    public ServiceResult whenValidate(@RequestParam(value = "id") String id) {
        return ServiceResult.success(SFConnector.testQueryCustomerVisit(id));
    }

}
