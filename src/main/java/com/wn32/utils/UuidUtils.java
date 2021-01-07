package com.wn32.utils;

import java.util.Locale;
import java.util.UUID;

public class UuidUtils {

    public static String getUuid32(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-","").toUpperCase(Locale.ROOT);
        return uuid;
    }


    public static String getUuid64(){

        return getUuid32() + getUuid32();
    }

}
