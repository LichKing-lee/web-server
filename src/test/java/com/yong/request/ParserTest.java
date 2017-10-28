package com.yong.request;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class ParserTest {
    private Parser parser;

    @Before
    public void setUp(){
        this.parser = new Parser(createHttpRequestMessages(""));
    }

    private List<String> createHttpRequestMessages(String parameter){
        return Arrays.stream(("GET /" + parameter + " HTTP/1.1\n" +
                "Host: localhost:9000\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "Cookie: Idea-c183be0=6d749401-5138-40a9-abae-769a66d82c5a; Webstorm-d8ff14a7=0a33e617-de6a-437a-9d9f-c04ea3d16011; _ga=GA1.1.402499999.1492495789\n" +
                "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Safari/604.1.38\n" +
                "Accept-Language: ko-kr\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: keep-alive").split("\n"))
                .collect(toList());
    }

    @Test
    public void parseMethod() throws Exception {
        String method = this.parser.parseMethod();

        assertThat(method, is("GET"));
    }

    @Test
    public void parseUri(){
        String method = this.parser.parseUri();

        assertThat(method, is("/"));
    }

    @Test
    public void parseParameter_no_parameter(){
        Map<String, String> parameterMap = this.parser.parseParameter();

        assertTrue(parameterMap.isEmpty());
    }

    @Test
    public void parseParameter_has_parameter(){
        Parser parser = new Parser(createHttpRequestMessages("?abc=123&ppp=&vvv=333"));
        Map<String, String> parameterMap = parser.parseParameter();

        assertThat(parameterMap.get("abc"), is("123"));
        assertThat(parameterMap.get("ppp"), is(""));
        assertThat(parameterMap.get("vvv"), is("333"));
        assertThat(parameterMap.get("ttt"), is(nullValue()));
    }

    @Test
    public void parseHeader(){
        Map<String, String> headerMap = this.parser.parseHeader();

        assertThat(headerMap.get("Host"), is("localhost:9000"));
        assertThat(headerMap.get("User-Agent"), containsString("Mozilla"));
    }
}