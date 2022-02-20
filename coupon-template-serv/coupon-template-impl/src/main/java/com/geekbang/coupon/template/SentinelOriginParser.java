package com.geekbang.coupon.template;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Component
@Slf4j
public class SentinelOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        log.info("request {}, header {}",httpServletRequest.getParameterMap(),httpServletRequest.getHeaderNames());
        httpServletRequest.getParameterMap().keySet().stream().forEach(el-> System.out.println(el));
        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s);
        }


        return httpServletRequest.getHeader("SentinelResource");
    }
}
