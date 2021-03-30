package piranha.examples.nano.http.server.tests;

import piranha.examples.nano.http.server.Main;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void httpRequest() throws InterruptedException, ExecutionException {

        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("http://localhost:8080")).timeout(Duration.of(5, ChronoUnit.SECONDS)).build();
        var asyncResponse = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        Main.main(new String[0]);
        HttpResponse<String> stringHttpResponse = asyncResponse.get();

        assertTrue(stringHttpResponse.body().contains("Invoked from an HTTP request"));
    }

}
