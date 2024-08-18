package com.user.controller;

import com.user.dto.request.UserDetailsRequest;
import com.user.dto.response.AllUserDetailsResponse;
import com.user.dto.response.EmployeeDetailsResponse;
import com.user.dto.response.UserDetailsResponse;
import com.user.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userDetails")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/{userId}")
    public UserDetailsResponse getUserDetails(@PathVariable String userId) {
        return userDetailsService.getUserDetails(userId);
    }

    @GetMapping("/allUserDetails/{pageNumber}/{pageSize}")
    public AllUserDetailsResponse getAllUserDetails(@PathVariable Integer pageNumber, @PathVariable Integer pageSize) {
        return userDetailsService.getAllUserDetails(pageNumber, pageSize);
    }

    @PostMapping("/saveUserDetails")
    public String saveUserDetails(@RequestBody UserDetailsRequest userDetailsRequest) {
        return userDetailsService.saveUserDetails(userDetailsRequest);
    }

    @GetMapping("/restCall")
    public EmployeeDetailsResponse getEmployeeDetails() {
        return userDetailsService.getEmployeeDetails();
    }
}
