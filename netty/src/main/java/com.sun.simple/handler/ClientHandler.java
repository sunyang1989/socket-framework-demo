package com.sun.simple.handler;

import com.sun.simple.bean.Person;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author yang.sun
 * @date 2016/5/13
 */
public class ClientHandler extends SimpleChannelHandler {
    /**
     * 当绑定到服务端的时候触发，打印"Hello world, I'm client."
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent event) {
        System.out.println("Hello world, I'm client.");
        Person person = new Person("sunyang",Math.random());
        event.getChannel().write(person);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        person = new Person("sunyang",Math.random());
        event.getChannel().write(person);
    }
}
