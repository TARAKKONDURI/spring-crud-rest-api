package com.crud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource(value = "classpath:tests.properties",ignoreResourceNotFound = true)
public class PropSource {

}
