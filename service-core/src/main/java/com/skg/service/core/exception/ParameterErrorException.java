package com.skg.service.core.exception;

import com.skg.service.core.constant.CommonConstants;
import org.springframework.util.StringUtils;

public class ParameterErrorException extends BaseException{

    public ParameterErrorException(String message) {
        super(message, CommonConstants.INVALIDE_PARAME);
    }

    public ParameterErrorException(){
        super(CommonConstants.INVALIDE_PARAME_MSG, CommonConstants.INVALIDE_PARAME);
    }
}
