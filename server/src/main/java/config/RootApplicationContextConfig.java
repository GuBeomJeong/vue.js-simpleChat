package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = {
        "dao",
        "service"
})
@Import({DbConfig.class})
public class RootApplicationContextConfig {
	
	
}
