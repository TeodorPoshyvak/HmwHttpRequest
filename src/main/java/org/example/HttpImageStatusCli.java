package org.example;
import java.io.IOException;
import java.util.Scanner;
import static java.net.HttpURLConnection.HTTP_OK;
public class HttpImageStatusCli {
    void askStatus(){
        boolean answer = true;
        while (answer) {
            Scanner switchCase = new Scanner(System.in);
            System.out.println("If you want to download the file, press - Y \nIf you want to stop the program, press - N");
            switch (switchCase.next()) {
                case "Y":
                    System.out.println("Enter HTTP status code");
                    Scanner code = new Scanner(System.in);
                    try {
                        if (code.hasNextInt()) {
                            new HttpStatusImageDownloader().downloadStatusImage(code.nextInt());

                        } else if (code.nextInt() != HTTP_OK) {
                            System.out.println(String.format("There is not image for HTTP status %s", code.nextInt()));
                        }
                    } catch (IOException e) {
                        System.out.println("General I/O exception: " + e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case "N":
                    System.out.println("Close program");
                    answer = false;
                    break;
            }
        }
    }
}
