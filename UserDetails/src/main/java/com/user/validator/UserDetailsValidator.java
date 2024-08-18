package com.user.validator;

import com.user.dto.request.UserDetailsRequest;
import com.user.exception.CustomException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class UserDetailsValidator {

    public boolean validateUserId(String userId) {
        return ObjectUtils.isEmpty(userId);
    }

    public boolean validateUserDetails(UserDetailsRequest userDetailsRequest) {
        if (ObjectUtils.isEmpty(userDetailsRequest)) {
            throw new CustomException("Please provide User Details");
        }else if(ObjectUtils.isEmpty(userDetailsRequest.getUserID())){
            throw new CustomException("Please provide UserID Details");
        }else if(ObjectUtils.isEmpty(userDetailsRequest.getUsername())){
            throw new CustomException("Please provide User Name Details");
        }
        return true;
    }
}
