import com.example.demo.entity.Topic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.example.demo"})
@EntityScan("com.example.demo")
@EnableJpaRepositories("com.example.demo")
// adding swagger to app
@EnableSwagger2
public class ApiApp{
    public static void main(String[] args) {
        try{
            // running the app
            SpringApplication.run(ApiApp.class,args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
