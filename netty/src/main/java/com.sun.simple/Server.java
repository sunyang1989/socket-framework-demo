package com.sun.simple;

import com.sun.simple.handler.ServerHandler;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.serialization.ClassResolvers;
import org.jboss.netty.handler.codec.serialization.ObjectDecoder;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


/**
 * @author  sun
 * @date 2016/5/12
 */
public class Server {

    public static void main(String args[]) {
        // Server服务启动器
        ServerBootstrap bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));
        // 设置 处理客户端消息和各种消息事件的类(Handler)

        //ObjectDecoder：接收客户端传递的bean对象时，先decode
        bootstrap.setPipelineFactory(() -> Channels.pipeline(new ObjectDecoder(ClassResolvers.cacheDisabled(Server.class.getClassLoader())),new ServerHandler()));

        //简单客户端传递消息
        //bootstrap.setPipelineFactory(() -> Channels.pipeline(new ServerHandler()));

        // 开放8000端口供客户端访问。
        bootstrap.bind(new InetSocketAddress(8000));
    }
}
