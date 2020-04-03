package com.gpf.study.netty.fifth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyTestServerHandler extends SimpleChannelInboundHandler<MessageTypeOuter.MessageType> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageTypeOuter.MessageType msg) throws Exception {
        switch (msg.getDataType()) {
            case PersonType:
                System.out.println(msg.getPerson().getName());
                break;
            case DogType:
                System.out.println(msg.getDog().getName());
                break;
            case CatType:
                System.out.println(msg.getCat().getName());
                break;
        }
    }
}
