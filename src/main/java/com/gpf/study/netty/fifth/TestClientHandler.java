package com.gpf.study.netty.fifth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestClientHandler extends SimpleChannelInboundHandler<StudentOuter.Student> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, StudentOuter.Student msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        StudentOuter.Student student = StudentOuter.Student.newBuilder().setId(123).setName("张三").setEmail("123@qq.com").build();

        ctx.writeAndFlush(student);
    }
}
