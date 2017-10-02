package com.yong.request;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RequestGetTest {
    private Request request;
    private String httpMessage;

    @Before
    public void setUp(){
        this.httpMessage = "GET /?abc=123&bbb=999 HTTP/1.1\n" +
                "Host: 127.0.0.1:9000\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Safari/604.1.38\n" +
                "Accept-Language: ko-kr\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: keep-alive\n";

        this.request = new Request(this.httpMessage);
    }

    @Test
    public void getMethod(){
        assertThat(this.request.getMethod(), is("GET"));
    }

    @Test
    public void getParameter(){
        assertThat(this.request.getParameter("abc"), is("123"));
        assertThat(this.request.getParameter("bbb"), is("999"));
    }

    @Test
    public void getParameterMap(){
        Map<String, String> expected = new HashMap<>();
        expected.put("abc", "123");
        expected.put("bbb", "999");

        assertThat(this.request.getParameterMap(), is(expected));
    }

    @Test
    public void getRequestUri(){
        assertThat(this.request.getRequestUri(), is("/"));
    }

    @Test
    public void getHeader(){
        assertThat(this.request.getHeader("Accept-Language"), is("ko-kr"));
    }
}