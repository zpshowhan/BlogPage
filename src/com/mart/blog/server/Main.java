package com.mart.blog.server;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class Main {

	public static void main(String[] args) throws Exception {
		 Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[] { connector });
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
//        context.addServlet(HelloServlet.class, "/hello");//添加servlet控制
//        HandlerCollection handlers = new HandlerCollection();
//        handlers.setHandlers(new Handler[] { context, new DefaultHandler() });
//        server.setHandler(handlers);
        server.setHandler(context);
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("F:\\tools\\apache-tomcat-7.0.69\\webapps\\BlogPage");
        server.setHandler(resourceHandler);
        server.start();
        server.join();
	}
}
