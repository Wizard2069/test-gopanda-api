package com.company.demo;

public class BaseUrl {
    
    private static String host = "app.gopanda.asia"; // app.gopanda.asia
    private static int port = 8080;
    private static String apiPath = "api"; // api
    
    public static String getBaseUrl(String path) {
        return String.format("https://%s/%s%s", host, apiPath, path);
    }
    
}
