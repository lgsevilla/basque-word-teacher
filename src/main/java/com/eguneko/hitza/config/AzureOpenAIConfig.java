package com.eguneko.hitza.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureOpenAIConfig {

    @Value("${azure.openai.api.key}")
    private String apiKey;

    @Value("${azure.openai.endpoint}")
    private String endpoint;

    @Value("${azure.openai.deployment}")
    private String deployment;

    @Value("${azure.openai.api.version}")
    private String apiVersion;

    public String getApiKey() {
        return apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getDeployment() {
        return deployment;
    }

    public String getApiVersion() {
        return apiVersion;
    }
}
