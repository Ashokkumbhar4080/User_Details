package com.user.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse {
    public String statusCode;
    public String statusDescription;
    public String timestamp;
}
