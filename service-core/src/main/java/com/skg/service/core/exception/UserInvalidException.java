package com.skg.service.core.exception;

import com.skg.service.core.constant.CommonConstants;

public class UserInvalidException extends BaseException {
    public UserInvalidException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }

}
