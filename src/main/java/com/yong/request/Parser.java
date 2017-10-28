package com.yong.request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class Parser {
    private String[] firstLineArr;
    private List<String> headers;

    public Parser(List<String> lines){
        this.firstLineArr = lines.get(0).split(" ");
        this.headers = lines.subList(1, lines.size());
    }

    public Request parseRequest(){
        return null;
    }

    String parseMethod(){
        return firstLineArr[0];
    }

    String parseUri(){
        return firstLineArr[1];
    }

    Map<String, String> parseParameter(){
        Map<String, String> parameterMap = new HashMap<>();

        if(hasParameter()){
            String parameter = firstLineArr[1].split("\\?")[1];

            for(String element : parameter.split("&")){
                String[] arr = element.split("=");

                parameterMap.put(arr[0], arr.length == 2 ? arr[1] : "");
            }
        }

        return parameterMap;
    }

    private boolean hasParameter(){
        return firstLineArr[1].contains("?");
    }

    Map<String, String> parseHeader(){
        return this.headers.stream()
                .map(header -> header.split(": "))
                .collect(toMap(arr -> arr[0], arr -> arr[1]));
    }
}
