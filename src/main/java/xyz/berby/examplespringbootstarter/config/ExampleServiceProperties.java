package xyz.berby.examplespringbootstarter.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("xyz.berby")
public class ExampleServiceProperties {


    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
