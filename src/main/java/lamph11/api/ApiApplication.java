package lamph11.api;

import com.zaxxer.hikari.HikariDataSource;
import lamph11.api.entity.Category;
import lamph11.api.service.RegisterEvent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Getter
@Setter
public class ApiApplication {

    @Autowired
    private HikariDataSource dataSource;
    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(){
        return args -> {
            eventPublisher.publishEvent(new RegisterEvent(new Category()));
            System.out.println(dataSource.getMaximumPoolSize());;
        };
    }

}
