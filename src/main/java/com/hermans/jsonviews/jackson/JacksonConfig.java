package com.hermans.jsonviews.jackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Jackson Configuration
 *
 * Maxxton Group 2016
 *
 * @author Robin Hermans (info@robinhermans.net)
 */
@Configuration
public class JacksonConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @PostConstruct
    public void configureObject() {
        objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
    }
}
