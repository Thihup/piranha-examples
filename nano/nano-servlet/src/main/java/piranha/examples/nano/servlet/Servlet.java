package piranha.examples.nano.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.getWriter().println("""
                <!doctype html>
                <html lang="en">
                    <head>
                        <title>Piranha Nano - Servlet test</title>
                    </head>
                    
                    <body>
                        <h1>Hello, Piranha!</h1>
                    </body>
                </html>
                """);
    }
}
