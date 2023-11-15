package org.example;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HttpStatusCheckerTest {

    @Test
    void getStatusImage() throws IOException {

        String url = new HttpStatusChecker().getStatusImage(200);

        assertEquals("https://http.cat/200.jpg", url);
    }

    @Test
    void getStatusImageFailTest() throws Exception {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        assertThrows(FileNotFoundException.class,
                () -> statusChecker.getStatusImage(-999999999));
    }
}