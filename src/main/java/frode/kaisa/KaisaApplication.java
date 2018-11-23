package frode.kaisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@SpringBootApplication
public class KaisaApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaisaApplication.class, args);
    }
}
