package com.skg.service.core.util;

import java.util.Random;

public  class PasswordUtil {

    public static String encodePassword(String password){
        String randomNum = getRandomCharAndNumr(6);
        return new Blowfish(randomNum).encryptString(password)+randomNum;
    }

    public static String decodePassword(String enpassword){
        return new Blowfish(enpassword.substring(enpassword.length()-6)).decryptString(enpassword.substring(0,enpassword.length()-6));
    }

    public static String getRandomCharAndNumr(Integer length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            boolean b = random.nextBoolean();
            if (b) { // 字符串
                // int choice = random.nextBoolean() ? 65 : 97; 取得65大写字母还是97小写字母
                str += (char) (97 + random.nextInt(26));// 取得大写字母
            } else { // 数字
                str += String.valueOf(random.nextInt(10));
            }
        }
        return str;
    }

    public static void main(String[] args){
        System.out.println(PasswordUtil.encodePassword("123456"));
    }
}
