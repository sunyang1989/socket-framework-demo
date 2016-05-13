package com.sun.simple;

import com.sun.simple.handler.ClientHandler;
import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ObjectEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @author  sun
 * @date 2016/5/12
 */
public class Client {
    public static void main(String args[]) {
        // Client服务启动器
        ClientBootstrap bootstrap = new ClientBootstrap(
                new NioClientSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        //设置 处理服务端消息和各种消息事件的类(Handler)

        //ObjectEncoder：客户端传递bean对象时，先encode
        bootstrap.setPipelineFactory(() -> Channels.pipeline(new ObjectEncoder(),new ClientHandler()));

        //简单客户端传递消息
        //bootstrap.setPipelineFactory(() -> Channels.pipeline(new ClientHandler()));

        // 连接到本地的8000端口的服务端
        bootstrap.connect(new InetSocketAddress("127.0.0.1", 8000));
    }
}
