package com.kaka.core.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @program: high-performance-gateway
 * @description: 核心上下文接口定义
 * @author: quanhongjiang
 * @create: 2025-04-12 15:57
 **/

public interface IContext {
    /**
     * 一个请求正在执行中的状态
     */
    int RUNNING = 0;

    /**
     * 标志请求结束，写回Response
     */
    int WRITTEN = 1;

    /**
     * 写回成功后，设置该标识
     */
    int COMPLETED = 2;

    /**
     * 整个网关请求完毕，彻底结束
     */
    int TERMINATED = -1;

    /**
     * 设置上下文状态为正常运行状态
     */
    void running();

    /**
     * 设置上下文状态为标志写回
     */
    void written();

    /**
     * 设置上下文状态为标志写回成功
     */
    void completed();

    /**
     * 设置上下文状态为彻底结束
     */
    void terminated();

    /**
     * 判断网关状态
     */
    boolean isRunning();
    boolean isWritten();
    boolean isCompleted();
    boolean isTerminated();

    /**
     * 获取请求转换协议
     */
    String getProtocol();

    /**
     * 获取请求转换规则
     */
    String getRule();

    /**
     * 获取请求对象
     */
    Object getRequest();

    /**
     * 获取请求结果
     */
    Object getResponse();

    /**
     * 获取异常信息
     */
    Throwable getThrowable();

    /**
     * 获取上下文参数
     */
    Object getAttribute(String key);

    /**
     * 设置上下文参数
     */
    void setAttribute(String key,Object obj);

    /**
     * 获取Netty上下文
     * @return
     */
    ChannelHandlerContext getNettyCtx();

    /**
     * 是否保持连接
     */
    boolean isKeepAlive();

    /**
     * 释放资源
     */
    void releaseRequest();

    /**
     * 设置回调函数
     * @param coconsumer
     */
   void setCompletedCallBack(Consumer<IContext> coconsumer);

    /**
     * 设置回调函数
     * @param coconsumer
     */
   void invokeCompletedCallBack(Consumer<IContext> coconsumer);






}
