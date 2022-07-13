package cn.liondance.liondancejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunwei
 */
@SpringBootApplication
@RestController
@EnableJpaAuditing
public class LionDanceJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LionDanceJpaApplication.class, args);
    }

}
