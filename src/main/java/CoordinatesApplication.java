import com.example.config.ClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = {"com.example.server", "com.example.config"})
@EnableConfigurationProperties(ClientConfig.class)
public class CoordinatesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoordinatesApplication.class, args);
    }
}
