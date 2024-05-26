package org.example.friendexam;

import org.example.friendexam.레포지토리.FriendRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FriendexamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FriendexamApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(FriendRepository repository){
        return args -> {
            repository.findAll().forEach(System.out::println);
        // forEach를 통해서 하나씩 출력
            // toString을 오버라이드 했기에 가능하다.
        };
    }

}
