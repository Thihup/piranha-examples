package piranha.examples.nano.servlet;

import cloud.piranha.nano.NanoPiranha;
import cloud.piranha.nano.NanoPiranhaBuilder;
import cloud.piranha.nano.NanoRequest;
import cloud.piranha.nano.NanoRequestBuilder;
import cloud.piranha.nano.NanoResponse;
import cloud.piranha.nano.NanoResponseBuilder;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) throws ServletException, IOException {
        NanoPiranha nanoPiranha = new NanoPiranhaBuilder()
                .servlet("Hello Servlet", new Servlet())
                .build();

        OutputStream outputStream = Files.newOutputStream(Path.of("target/index.html"), CREATE);

        NanoRequest request = new NanoRequestBuilder().build();

        NanoResponse response = new NanoResponseBuilder().outputStream(outputStream).build();

        nanoPiranha.service(request, response);

    }
}
