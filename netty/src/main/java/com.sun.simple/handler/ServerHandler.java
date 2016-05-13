package com.sun.simple.handler;

import com.sun.simple.bean.Person;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author yang.sun
 * @date 2016/5/13
 */
public class ServerHandler extends SimpleChannelHandler {
    /**
     * 当有客户端绑定到服务端的时候触发，打印"Hello world, I'm server."
     */
    @Override
    public void channelConnected(
            ChannelHandlerContext ctx,
            ChannelStateEvent e) {
        System.out.println("Hello world, I'm server.");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        //接收到参数bean
        Person person = (Person) e.getMessage();
        System.out.println(person.toString());
    }
}
