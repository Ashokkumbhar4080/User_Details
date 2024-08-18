package com.user.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDetailsResponse extends CommonResponse {

    private String status;
    private List<EmployeeDetails> data;
    private String message;

}
