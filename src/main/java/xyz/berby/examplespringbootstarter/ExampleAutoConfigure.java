package xyz.berby.examplespringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import xyz.berby.examplespringbootstarter.config.ExampleServiceProperties;
import xyz.berby.examplespringbootstarter.service.ExampleService;
import xyz.berby.examplespringbootstarter.service.impl.ExampleServiceImpl;

import java.util.Map;

@Configuration
@ImportResource("classpath:spring-example.xml")
@EnableConfigurationProperties(ExampleServiceProperties.class)
public class ExampleAutoConfigure {

    private ExampleServiceProperties properties;

    @Autowired
    public ExampleAutoConfigure(ExampleServiceProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "xyz.berby", value = "enabled", havingValue = "true")
    public ExampleService exampleService() {

        return new ExampleServiceImpl(this.properties.getConfig());
    }

}
