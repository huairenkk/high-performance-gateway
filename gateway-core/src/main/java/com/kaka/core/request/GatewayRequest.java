package com.kaka.core.request;

import org.asynchttpclient.Request;
import org.asynchttpclient.cookie.Cookie;

/**
 * @program: high-performance-gateway
 * @description: 网关请求对象
 * @author: quanhongjiang
 * @create: 2025-04-13 23:57
 **/

public class GatewayRequest implements IGatewayRequest{

    /**
     * 服务唯一ID
     */
    private final String uniqueId;

    /**
     * 进入网关开始时间
     */
    private final long beginTime;

    /**
     * 结束时间
     */
    private final long endTime;

    @Override
    public void setModifyHost(String host) {

    }

    @Override
    public String getModifyHost() {
        return null;
    }

    @Override
    public void setModifyPath(String path) {

    }

    @Override
    public String getModifyPath() {
        return null;
    }

    @Override
    public void addHeader(CharSequence name, String value) {

    }

    @Override
    public void setHeader(CharSequence name, String value) {

    }

    @Override
    public void addQueryParam(String name, String value) {

    }

    @Override
    public void addFormParam(String name, String value) {

    }

    @Override
    public void addOrReplaceCookie(Cookie cookie) {

    }

    @Override
    public void setRequestTimeout(int timeout) {

    }

    @Override
    public String getFinalUrl() {
        return null;
    }

    @Override
    public Request build() {
        return null;
    }
}
