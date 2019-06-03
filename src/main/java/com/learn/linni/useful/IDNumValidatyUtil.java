package com.learn.linni.useful;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 校验身份证是否合格
 * Created by @毛瑞 on 2019/4/2.
 * @see <a href="https://30ke.cn">三十课</a>
 */
public class IDNumValidatyUtil {

    private static boolean checkProv(String val) {
        if(val.matches("^[1-9][0-9]*")) {
            String[] prefix = {"11","12","13","14","15","21","22","23","31","32","33","34","35","36","37","41","42","43","44","45","46","50","51","52","53","54","61","62","63","64","65","71","81","82"};
            Set<String> prefixMap =  new HashSet<String>(Arrays.asList(prefix));
            if(prefixMap.contains(val)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkDate(String val) {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        try {
            df.setLenient(false);
            df.parse(val);
            return true;
        } catch (ParseException e) {
//            e.printStackTrace();
        }
        return false;
    }


    private static boolean checkCode(String val) {
        String regex = "^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
        Integer[] factor = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
        String[] parity = { "1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2" };
        if(val.matches(regex)) {
            String code = val.substring(17);
            int sum = 0;
            for(int i=0; i<17; i++) {
                sum += Integer.parseInt(val.charAt(i)+"")*factor[i];
            }
            if(parity[sum % 11].equals(code.toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkID(String val) {
        if(checkCode(val)) {
            String date = val.substring(6,14);
            if(checkDate(date) && checkProv(val.substring(0,2))) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(checkID("11010519491231002X"));
        System.out.println(checkID("110105194912310021"));
        System.out.println(checkID("110105194902310026"));
        System.out.println(checkID("160105194912310029"));
    }
}

