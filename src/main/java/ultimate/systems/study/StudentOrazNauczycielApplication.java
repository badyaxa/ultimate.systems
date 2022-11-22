package ultimate.systems.study;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentOrazNauczycielApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentOrazNauczycielApplication.class, args);
        openHomePage();
    }

    private static void openHomePage() {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8080/swagger-ui/#");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
