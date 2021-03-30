package piranha.examples.nano.server.pages.test;

import piranha.examples.nano.server.pages.Main;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testJSP() throws Exception {
        Main.main(new String[0]);
        var path = Paths.get("target/output.html");
        var lines = Files.readAllLines(path);
        assertTrue(lines.stream().anyMatch(x -> x.contains("Hello, Piranha")));
        assertTrue(lines.stream().anyMatch(x -> x.contains("/index.jsp")));
        assertTrue(lines.stream().anyMatch(x -> x.contains("Text blocks in JSP")));
        assertTrue(lines.stream().anyMatch(x -> x.contains("10 + 5 == 15")));
    }
}
