package ru.rassafel.quicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class QuickerApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(QuickerApplication.class);
        ConfigurableApplicationContext context = application.run(args);
    }

    /**
     * Override this clock for testing
     *
     * @return system clock
     */
    @Bean
    Clock systemClock() {
        return Clock.systemDefaultZone();
    }
}
