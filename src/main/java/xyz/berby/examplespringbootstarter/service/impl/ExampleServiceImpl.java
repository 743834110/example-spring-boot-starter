package xyz.berby.examplespringbootstarter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.berby.examplespringbootstarter.service.ExampleService;



public class ExampleServiceImpl implements ExampleService {

    private String config;

    public ExampleServiceImpl(String config) {
        this.config = config;

    }

    public String[] split(String separatorChar) {

        return StringUtils.split(config, separatorChar);
    }
}
