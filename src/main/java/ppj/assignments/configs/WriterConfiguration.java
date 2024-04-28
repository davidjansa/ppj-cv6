package ppj.assignments.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import ppj.assignments.writer.DevelWriter;
import ppj.assignments.writer.ProdWriter;
import ppj.assignments.writer.Writer;

@Configuration
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class WriterConfiguration {

    @Profile("devel")
    @Bean
    public Writer develWriter() {
        return new DevelWriter();
    }

    @Profile("!devel")
    @Bean
    public Writer prodWriter() {
        return new ProdWriter();
    }
}
