package com.kaka.core.context;

import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * @program: high-performance-gateway
 * @description: 核心上下文基础类
 * @author: quanhongjiang
 * @create: 2025-04-12 17:17
 **/

public class BasicContext implements IContext {

    /**
     * 转发协议
     */
    protected final String protocol;

    /**
     * 状态，多线程情况下考虑使用volatile关键字
     */
    protected volatile int status = IContext.RUNNING;

    /**
     * Netty上下文
     */
    protected final ChannelHandlerContext nettyCtx;

    /**
     * 上下文参数集合
     */
    protected final Map<String, Object> attributes = new HashMap<>();

    /**
     * 请求过程中发生的异常
     */
    protected Throwable throwable;

    /**
     * 是否保持长连接
     */
    protected final boolean keepAlive;

    /**
     * 是否已经释放资源
     */
    protected final AtomicBoolean requestReleased = new AtomicBoolean(false);

    /**
     * 构造函数
     *
     * @param protocol
     * @param nettyCtx
     * @param keepAlive
     */
    public BasicContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive) {
        this.protocol = protocol;
        this.nettyCtx = nettyCtx;
        this.keepAlive = keepAlive;
    }

    /**
     * 存放回调函数的集合
     */
    protected List<Consumer<IContext>> completedCallBacks;

    @Override
    public void running() {
        status = IContext.RUNNING;
    }

    @Override
    public void written() {
        status = IContext.WRITTEN;
    }

    @Override
    public void completed() {
        status = IContext.COMPLETED;
    }

    @Override
    public void terminated() {
        status = IContext.TERMINATED;
    }

    @Override
    public boolean isRunning() {
        return status == IContext.WRITTEN;
    }

    @Override
    public boolean isWritten() {
        return status == IContext.WRITTEN;
    }

    @Override
    public boolean isCompleted() {
        return status == IContext.COMPLETED;
    }

    @Override
    public boolean isTerminated() {
        return status == IContext.TERMINATED;
    }

    @Override
    public String getProtocol() {
        return this.protocol;
    }

    @Override
    public String getRule() {
        return null;
    }

    @Override
    public Object getRequest() {
        return null;
    }

    @Override
    public Object getResponse() {
        return null;
    }

    @Override
    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override
    public Object getAttribute(String key) {
        return this.attributes.get(key);
    }

    @Override
    public void setAttribute(String key, Object obj) {
        attributes.put(key, obj);
    }

    @Override
    public ChannelHandlerContext getNettyCtx() {
        return this.nettyCtx;
    }

    @Override
    public boolean isKeepAlive() {
        return this.keepAlive;
    }

    @Override
    public void releaseRequest() {
        this.requestReleased.compareAndSet(false, true);
    }

    @Override
    public void setCompletedCallBack(Consumer<IContext> coconsumer) {
        if (completedCallBacks == null) {
            completedCallBacks = new ArrayList<>();
        }
        completedCallBacks.add(coconsumer);
    }

    @Override
    public void invokeCompletedCallBack(Consumer<IContext> coconsumer) {
        if (completedCallBacks != null) {
            completedCallBacks.forEach(call->call.accept(this));
        }
    }
}
