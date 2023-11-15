package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.example.Util.FILE_ALREADY_EXIST_TEXT;
import static org.example.Util.FILE_NOT_FOUND_EXCEPTION_TEXT;
public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) throws IOException {
        String url = new HttpStatusChecker().getStatusImage(code);

        try(InputStream inputStream = new URL(url).openStream()) {
            String path = String.format("./Files/%s.png", code);
            if(!new File(path).exists()) {
                Files.copy(inputStream, Paths.get(path));
                System.out.println("File download!");
            }else {
                System.out.println(String.format( FILE_ALREADY_EXIST_TEXT, code));
            }
        } catch (Exception e) {
            throw new FileNotFoundException(String.format(FILE_NOT_FOUND_EXCEPTION_TEXT, code));
        }
    }
}
