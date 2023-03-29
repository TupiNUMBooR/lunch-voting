package ru.tupi.lunchvoting;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.tupi.lunchvoting.repository.UserRepository;

@SpringBootApplication
@AllArgsConstructor
public class LunchVotingApplication implements ApplicationRunner {
    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(LunchVotingApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(userRepository.findAll());
        System.out.println(userRepository.findByLastNameContainingIgnoreCase("last"));
    }
}
