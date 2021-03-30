package piranha.examples.nano.server.pages;

import cloud.piranha.nano.NanoPiranha;
import cloud.piranha.nano.NanoPiranhaBuilder;
import cloud.piranha.nano.NanoRequest;
import cloud.piranha.nano.NanoRequestBuilder;
import cloud.piranha.nano.NanoResponse;
import cloud.piranha.nano.NanoResponseBuilder;
import jakarta.servlet.ServletException;
import org.apache.jasper.servlet.JspServlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {

    private static final String WASP_SERVLET = "WaSP Servlet";

    public static void main(String[] args) throws ServletException, IOException {
        NanoPiranha nanoPiranha = new NanoPiranhaBuilder()
                .directoryResource("src/main/webapp")
                .servlet(WASP_SERVLET, new JspServlet())
                .servletInitParam(WASP_SERVLET, "classpath", System.getProperty("jdk.module.path", System.getProperty("java.class.path")))
                .servletInitParam(WASP_SERVLET, "compilerSourceVM", "16")
                .servletInitParam(WASP_SERVLET, "compilerTargetVM", "16")
                .servletInitParam(WASP_SERVLET, "fork", "false")
                .build();


        OutputStream outputStream = Files.newOutputStream(Path.of("target/output.html"), CREATE);

        NanoRequest request = new NanoRequestBuilder()
                .servletPath("/index.jsp")
                .build();

        NanoResponse response = new NanoResponseBuilder().outputStream(outputStream).build();

        nanoPiranha.service(request, response);

    }
}
