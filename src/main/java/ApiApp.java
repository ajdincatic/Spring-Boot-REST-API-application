import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example.demo")
// adding swagger to app
@EnableSwagger2
public class ApiApp {
    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class,args);
    }
}
