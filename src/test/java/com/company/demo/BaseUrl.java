package com.company.demo;

public class BaseUrl {
    
    private static String host = "localhost"; // app.gopanda.asia
    private static int port = 8080;
    private static String apiPath = "api"; // api
    
    public static String getBaseUrl(String path) {
        return String.format("http://%s:%s/%s%s", host, port, apiPath, path);
    }
    
}
