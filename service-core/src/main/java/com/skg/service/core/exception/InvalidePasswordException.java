package com.skg.service.core.exception;

import com.skg.service.core.constant.CommonConstants;

public class InvalidePasswordException extends BaseException{

    public InvalidePasswordException(){
        super(CommonConstants.INVALIDE_PASSWORD_MSG,CommonConstants.INVALIDE_PASSWORD);
    }

    public InvalidePasswordException(String msg){
        super(msg,CommonConstants.INVALIDE_PASSWORD);
    }

}
