package WebAppy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        
        final ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    context.close();
                } catch (Exception e) {
                    System.exit(-1);
                }
            }
        });
        
    }
    
}

