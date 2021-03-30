package piranha.examples.nano.servlet.test;

import piranha.examples.nano.servlet.Main;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {

    @Test
    void testIndexHtml() throws Exception {
        Main.main(new String[0]);
        var path = Paths.get("target/index.html");
        assertTrue(Files.lines(path).anyMatch(x -> x.contains("Hello, Piranha")));
    }
}
