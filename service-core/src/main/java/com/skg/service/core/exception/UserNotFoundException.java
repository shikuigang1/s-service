package com.skg.service.core.exception;

import com.skg.service.core.constant.CommonConstants;

public class UserNotFoundException extends BaseException {

    public UserNotFoundException(String message){
        super(message,CommonConstants.USERNOTFOUNDE_ERROR);
    }
    public UserNotFoundException(){
        super(CommonConstants.USERNOTFOUNDE_ERROR_MSG,CommonConstants.USERNOTFOUNDE_ERROR);
    }

}
