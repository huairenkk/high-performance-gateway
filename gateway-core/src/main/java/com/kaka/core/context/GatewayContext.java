package com.kaka.core.context;

import com.kaka.core.request.GatewayRequest;
import io.netty.channel.ChannelHandlerContext;

/**
 * @program: high-performance-gateway
 * @description: 网关上下文
 * @author: quanhongjiang
 * @create: 2025-04-13 23:22
 **/

public class GatewayContext extends BasicContext{

    public GatewayRequest request;

//    public GatewayResponse response;

//    public Rule rule;
    /**
     * 构造函数
     *
     * @param protocol
     * @param nettyCtx
     * @param keepAlive
     */
    public GatewayContext(String protocol, ChannelHandlerContext nettyCtx, boolean keepAlive) {
        super(protocol, nettyCtx, keepAlive);
    }
}
