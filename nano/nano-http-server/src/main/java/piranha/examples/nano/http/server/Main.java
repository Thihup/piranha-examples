package piranha.examples.nano.http.server;

import cloud.piranha.http.api.HttpServer;
import cloud.piranha.http.nano.NanoHttpServerProcessor;
import cloud.piranha.nano.NanoPiranha;
import cloud.piranha.nano.NanoPiranhaBuilder;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NanoPiranha nanoPiranha = new NanoPiranhaBuilder()
                .servlet("SimpleServlet", new SimpleServlet())
                .build();

        var nanoHttpServerProcessor = new NanoHttpServerProcessor(nanoPiranha);

        var httpServer = ServiceLoader.load(HttpServer.class).findFirst().orElseThrow();
        httpServer.setServerPort(8080);
        httpServer.setHttpServerProcessor(nanoHttpServerProcessor);

        System.out.println("Starting HTTP server (port 8080) for two seconds");
        httpServer.start();

        Thread.sleep(2000);

        httpServer.stop();
    }

    public static class SimpleServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/plain");
            response.getWriter().println("Invoked from an HTTP request");
        }
    }

}
