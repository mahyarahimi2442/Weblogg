package ir.ac.weblogg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ir.ac.weblogg")
public class WebloggApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebloggApplication.class, args);
        System.out.println("start app");
    }

}
