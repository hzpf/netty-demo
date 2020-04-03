package com.gpf.study.netty.fifth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyTestClientHandler extends SimpleChannelInboundHandler<MessageTypeOuter.MessageType> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageTypeOuter.MessageType msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        long time = System.currentTimeMillis() % 3;
        MessageTypeOuter.MessageType messageType;
        switch ((int) time) {
            case 0 : messageType = MessageTypeOuter.MessageType.newBuilder()
                    .setDataType(MessageTypeOuter.MessageType.DataType.PersonType)
                    .setPerson(MessageTypeOuter.Person.newBuilder().setName("一个人").build())
                    .build();
            break;

            case 1: messageType = MessageTypeOuter.MessageType.newBuilder()
                    .setDataType(MessageTypeOuter.MessageType.DataType.DogType)
                    .setDog(MessageTypeOuter.Dog.newBuilder().setName("一条狗").build())
                    .build();
            break;

            case 2: messageType = MessageTypeOuter.MessageType.newBuilder()
                    .setDataType(MessageTypeOuter.MessageType.DataType.CatType)
                    .setCat(MessageTypeOuter.Cat.newBuilder().setName("一只猫").build())
                    .build();
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + time);
        }

        ctx.writeAndFlush(messageType);
    }
}
