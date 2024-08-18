package com.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetailsResponse extends CommonResponse {
    private String userID;
    private String username;
    private String city;
    private String country;
}
