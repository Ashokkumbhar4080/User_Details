package com.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AllUserDetailsResponse extends CommonResponse{
    private List<UserDetailsResponse> data;
}
