package com.gpf.study.netty.fifth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<StudentOuter.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentOuter.Student msg) throws Exception {
        System.out.println(msg.getId());
        System.out.println(msg.getName());
        System.out.println(msg.getEmail());
    }
}
