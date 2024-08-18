package com.user.service;

import com.user.constants.UserDetailsConstant;
import com.user.dto.request.UserDetailsRequest;
import com.user.dto.response.AllUserDetailsResponse;
import com.user.dto.response.EmployeeDetailsResponse;
import com.user.dto.response.UserDetailsResponse;
import com.user.exception.CustomException;
import com.user.proxy.EmployeeDetailProxy;
import com.user.repository.UserDetailsEntity;
import com.user.repository.UserDetailsRepository;
import com.user.validator.UserDetailsValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.user.constants.UserDetailsConstant.*;

@Service
public class UserDetailsService {

    @Autowired
    UserDetailsValidator userDetailsValidator;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    EmployeeDetailProxy employeeDetailProxy;

    public UserDetailsResponse getUserDetails(String userId) {
        UserDetailsResponse userDetailsResponse = new UserDetailsResponse();
        try {
            if (!userDetailsValidator.validateUserId(userId)) {
                Optional<UserDetailsEntity> optionalUserDetailsEntity = userDetailsRepository.findByUserID(userId);
                if (optionalUserDetailsEntity.isPresent()) {
                    UserDetailsEntity userDetails = optionalUserDetailsEntity.get();
                    BeanUtils.copyProperties(userDetails, userDetailsResponse);
                    userDetailsResponse.setStatusCode(SUCCESS_STATUS_CODE);
                    userDetailsResponse.setStatusDescription(SUCCESS_MSG);
                    return userDetailsResponse;
                }
                userDetailsResponse.setStatusCode(FAILED_STATUS_CODE);
                userDetailsResponse.setStatusDescription(USER_DETAIL_NOT_FOUND);
                return userDetailsResponse;

            } else {
                userDetailsResponse.setStatusCode(FAILED_STATUS_CODE);
                userDetailsResponse.setStatusDescription(USER_DETAIL_NOT_FOUND);
                return userDetailsResponse;
            }
        } catch (Exception e) {
            userDetailsResponse.setStatusCode(FAILED_STATUS_CODE);
            userDetailsResponse.setStatusDescription(COMMON_ERROR_MSG);
            return userDetailsResponse;
        }
    }

    public AllUserDetailsResponse getAllUserDetails(Integer pageNumber, Integer PageSize) {
        AllUserDetailsResponse allUserDetailsResponse = new AllUserDetailsResponse();
        UserDetailsResponse userDetailsResponse=null;
        List<UserDetailsResponse> listResponse = new ArrayList<>();
        try {
            Pageable pageable = PageRequest.of(pageNumber,PageSize);
                Page<UserDetailsEntity> userDetailsEntityPage = userDetailsRepository.findAll(pageable);
                if (!ObjectUtils.isEmpty(userDetailsEntityPage)) {
                    List<UserDetailsEntity> userDetailsEntityList = userDetailsEntityPage.getContent();
                    for(UserDetailsEntity response : userDetailsEntityList){
                        userDetailsResponse=new UserDetailsResponse();
                        BeanUtils.copyProperties(response, userDetailsResponse);
                        listResponse.add(userDetailsResponse);
                    }
                    allUserDetailsResponse.setData(listResponse);
                    allUserDetailsResponse.setStatusCode(SUCCESS_STATUS_CODE);
                    allUserDetailsResponse.setStatusDescription(SUCCESS_MSG);
                    return allUserDetailsResponse;
                }
                allUserDetailsResponse.setStatusCode(FAILED_STATUS_CODE);
                allUserDetailsResponse.setStatusDescription(USER_DETAIL_NOT_FOUND);
                return allUserDetailsResponse;
        } catch (Exception e) {
            allUserDetailsResponse.setStatusCode(FAILED_STATUS_CODE);
            allUserDetailsResponse.setStatusDescription(COMMON_ERROR_MSG);
            return allUserDetailsResponse;
        }
    }

    public String saveUserDetails(UserDetailsRequest userDetailsRequest) {
        try {
            if (userDetailsValidator.validateUserDetails(userDetailsRequest)) {
                Optional<UserDetailsEntity> optionalUserDetailsEntity =
                        userDetailsRepository.findByUserID(userDetailsRequest.getUserID());
                if (optionalUserDetailsEntity.isPresent()) {
                    throw new CustomException("Same User ID already available please change user ID");
                } else {
                    UserDetailsEntity userDetailsEntity = new UserDetailsEntity();
                    BeanUtils.copyProperties(userDetailsRequest, userDetailsEntity);
                    userDetailsRepository.save(userDetailsEntity);
                    return SUCCESS_MSG;
                }
            }
            return "FAILED";
        } catch (Exception e) {
            throw new CustomException(COMMON_ERROR_MSG);
        }
    }

    public EmployeeDetailsResponse getEmployeeDetails() {
        EmployeeDetailsResponse response = employeeDetailProxy.getEmployeeDetails();
        return response;
    }
}
