package com.yong.request;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private Map<String, String> parameterMap;
    private Map<String, String> headerMap;
    private String method;
    private String uri;

    public Request(){
        this.parameterMap = new HashMap<>();
        this.headerMap = new HashMap<>();
    }

    public String getParameter(String name){
        return this.parameterMap.get(name);
    }

    public Map<String, String> getParameterMap(){
        return new HashMap<>(this.parameterMap);
    }

    public String getHeader(String name){
        return this.headerMap.get(name);
    }

    public String getMethod(){
        return this.method;
    }

    public String getRequestUri(){
        return this.uri;
    }
}
