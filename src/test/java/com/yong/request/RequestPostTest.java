package com.yong.request;

import org.junit.Before;

public class RequestPostTest {
    private String httpMessage;

    @Before
    public void setUp(){
        this.httpMessage = "POST /?abc=1 HTTP/1.1\n" +
                "Host: 127.0.0.1:9000\n" +
                "Connection: keep-alive\n" +
                "Content-Length: 15\n" +
                "Origin: chrome-extension://aejoelaoggembcahagimdiliamlcdmfm\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36\n" +
                "Content-Type: application/x-www-form-urlencoded\n" +
                "Accept: */*\n" +
                "Accept-Encoding: gzip, deflate, br\n" +
                "Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4\n" +
                "\n" +
                "abc=123&bbb=999";
    }
}