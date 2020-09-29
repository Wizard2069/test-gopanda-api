package com.company.demo;

public class BaseUrl {
    
    private static String host = "localhost";
    private static int port = 8080;
    private static String apiPath = "api";
    
    public static String getBaseUrl(String path) {
        return String.format("http://%s:%s/%s%s", host, port, apiPath, path);
    }
    
}
