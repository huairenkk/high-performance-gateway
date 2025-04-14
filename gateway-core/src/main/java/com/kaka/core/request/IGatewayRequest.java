package com.kaka.core.request;

import org.asynchttpclient.Request;
import org.asynchttpclient.cookie.Cookie;

/**
 * @program: high-performance-gateway
 * @description: 提供可修改的Request参数操作接口
 * @author: quanhongjiang
 * @create: 2025-04-13 23:24
 **/


public interface IGatewayRequest {

    /**
     * 修改目标服务主机
     *
     * @param host
     */
    void setModifyHost(String host);

    /**
     * 获取修改后的目标服务主机
     */
    String getModifyHost();

    /**
     * 设置目标服务路径
     *
     * @param path
     */
    void setModifyPath(String path);

    /**
     * 获取目标服务路径
     */
    String getModifyPath();

    /**
     * 添加请求头信息
     */
    void addHeader(CharSequence name, String value);

    /**
     * 设置请求头信息
     */
    void setHeader(CharSequence name, String value);

    /**
     * Get 请求参数
     *
     * @param name
     * @param value
     */
    void addQueryParam(String name, String value);

    /**
     * POST 请求参数
     *
     * @param name
     * @param value
     */
    void addFormParam(String name, String value);

    /**
     * 添加或者替换Cookie
     *
     * @param cookie
     */
    void addOrReplaceCookie(Cookie cookie);

    /**
     * 设置请求超时时间
     *
     * @param timeout
     */
    void setRequestTimeout(int timeout);

    /**
     * 获取最终请求地址
     *
     * @return
     */
    String getFinalUrl();

    /**
     * 构造最终的请求对象
     *
     * @return
     */
    Request build();
}
