package com.sun.simple;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import com.sun.simple.handler.ServerHandler;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author yang.sun
 * @date 2016/5/13
 */
public class Server {
    // 定义监听端口
    private static final int PORT = 6488;
    public static void main(String[] args) throws IOException {
        // 创建服务端监控线程
        IoAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getSessionConfig().setReadBufferSize(2048);
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
        // 设置日志记录器
        acceptor.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置编码过滤器
        acceptor.getFilterChain().addLast(
                "codec",
                new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        // 指定业务逻辑处理器
        acceptor.setHandler(new ServerHandler());
        // 设置端口号
        acceptor.bind(new InetSocketAddress(PORT));
        // 启动监听线程
        acceptor.bind();
    }
}
