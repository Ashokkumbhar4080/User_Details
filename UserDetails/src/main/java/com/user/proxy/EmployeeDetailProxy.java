package com.user.proxy;

import com.user.dto.response.EmployeeDetailsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "employeeDetailProxy", url = "${host.url}")
public interface EmployeeDetailProxy {

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json")
    EmployeeDetailsResponse getEmployeeDetails();

}
