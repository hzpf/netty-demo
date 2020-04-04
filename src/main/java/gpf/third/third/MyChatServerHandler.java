package gpf.third.third;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) {
        // 服务器将收到的消息发送给其他用户
        Channel channel = ctx.channel();
        channelGroup.forEach( ch -> {
            if (channel != ch) {
                ch.writeAndFlush("来自" + channel.remoteAddress() + "的消息：" + msg);
            }
        });
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        // 一个用户上线，提醒其他用户
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush(channel.remoteAddress() + "上线");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 一个用户下线，提醒其他用户
        channelGroup.writeAndFlush(ctx.channel().remoteAddress() + "下线");
        // channelGroup 内部有一个监听器会自动 remove
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
