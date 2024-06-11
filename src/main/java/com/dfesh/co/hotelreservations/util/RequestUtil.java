package com.dfesh.co.hotelreservations.util;

import org.slf4j.MDC;

import java.util.UUID;

public class RequestUtil {

    public static void createRequestId() {
        MDC.put("REQUEST_ID", UUID.randomUUID().toString());
    }

    public static String getRequestId(){
        return MDC.get("REQUEST_ID");
    }

}
