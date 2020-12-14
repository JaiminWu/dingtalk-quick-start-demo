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

    private static final Logger bizLogger = LoggerFactory.getLogger(ConnectorController.class);

    @RequestMapping(value = "/connector/query", method = RequestMethod.GET)
    public ServiceResult whenLoaded(@RequestParam(value = "id") String id) {
        SFConnector sfConnector = new SFConnector();
        return ServiceResult.success(sfConnector.testQueryCustomerVisit(id));
    }

    @RequestMapping(value = "/connector/submit", method = RequestMethod.POST)
    public ServiceResult whenSubmit() {
        SFConnector sfConnector = new SFConnector();
        CustomerVisit customerVisit = new CustomerVisit().testObject();
//        customerVisit = customerVisit.testObject();
        System.out.println("Received a process create request");
        return ServiceResult.success(sfConnector.testCreateCustomerVisit(customerVisit));
    }

    @RequestMapping(value = "/connector/validate", method = RequestMethod.GET)
    public ServiceResult whenValidate(@RequestParam(value = "id") String id) {
        SFConnector sfConnector = new SFConnector();
        return ServiceResult.success(sfConnector.testQueryCustomerVisit(id));
    }

}
