package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {

    @Test
    void downloadStatusImage() throws IOException {
        new HttpStatusImageDownloader().downloadStatusImage(200);
        File file = new File("Files/200.png");
        assertTrue(file.exists());
    }
}