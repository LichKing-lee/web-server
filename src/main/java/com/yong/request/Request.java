package com.yong.request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Request {
    private Map<String, String> parameterMap;
    private Map<String, String> headerMap;
    private String requestUri;
    private String method;

    public Request(String httpMessage) {
        String[] lines = httpMessage.split("\n");
        firstLineParse(lines[0]);
        httpHeaderParse(lines);
    }

    private void firstLineParse(String firstLine) {
        String[] firstLineArr = firstLine.split(" ");
        String[] uri = firstLineArr[1].split("\\?");
        this.requestUri = uri[0];
        String parameter = uri[1];

        this.method = firstLineArr[0];
        this.parameterMap = Arrays.stream(parameter.split("&"))
                .map(str -> str.split("="))
                .collect(toMap(arr -> arr[0], arr -> arr[1]));
    }

    private void httpHeaderParse(String[] lines) {
        String[] headers = new String[lines.length - 1];
        System.arraycopy(lines, 1, headers, 0, lines.length - 1);

        this.headerMap = Arrays.stream(headers)
                .map(header -> header.split(":"))
                .collect(toMap(header -> header[0], header -> header[1].trim()));
    }

    public String getParameter(String name) {
        return this.parameterMap.get(name);
    }

    public Map<String, String> getParameterMap() {
        return new HashMap<>(this.parameterMap);
    }

    public String getMethod() {
        return method;
    }

    public String getRequestUri() {
        return requestUri;
    }

    public String getHeader(String name) {
        return headerMap.get(name);
    }
}
