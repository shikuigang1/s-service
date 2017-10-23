package com.skg.service.core.constant;


public class CommonConstants {



    public static final Integer INVALIDE_PARAME = 400;
    public static final String INVALIDE_PARAME_MSG = "参数错误";

    public static final String USERNOTFOUNDE_ERROR_MSG = "用户没有找到";
    public static final int USERNOTFOUNDE_ERROR = 40010;

    public static  final int INVALIDE_PASSWORD = 40011;
    public static  final String INVALIDE_PASSWORD_MSG = "密码错误";



    public static final Integer EX_TOKEN_ERROR_CODE = 40101;
    // 用户token异常
    public static final Integer EX_USER_INVALID_CODE = 40102;
    // 客户端token异常
    public static final Integer EX_CLIENT_INVALID_CODE = 40131;
    public static final Integer EX_CLIENT_FORBIDDEN_CODE = 40331;
    public static final Integer EX_OTHER_CODE = 500;
    public static final String CONTEXT_KEY_USER_ID = "currentUserId";
    public static final String CONTEXT_KEY_USERNAME = "currentUserName";
    public static final String CONTEXT_KEY_USER_NAME = "currentUser";
    public static final String CONTEXT_KEY_USER_TOKEN = "currentUserToken";
    public static final String JWT_KEY_USER_ID = "userId";
    public static final String JWT_KEY_NAME = "name";
}
