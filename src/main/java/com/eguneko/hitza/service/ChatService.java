package com.eguneko.hitza.service;

import com.eguneko.hitza.config.AzureOpenAIConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private AzureOpenAIConfig config;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAIResponse(String userMessage) {
        String url = String.format("%s/openai/deployments/%s/chat/completions?api-version=%s",
                config.getEndpoint(), config.getDeployment(), config.getApiVersion());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("api-key", config.getApiKey());

        Map<String, Object> message = Map.of("role", "user", "content", userMessage);
        Map<String, Object> requestBody = Map.of(
                "messages", List.of(message),
                "max_tokens", 100,
                "temperature", 0.7
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    entity,
                    Map.class
            );

            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            Map<String, Object> messageMap = (Map<String, Object>) choices.get(0).get("message");
            return messageMap.get("content").toString().trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "Sorry, I couldn't connect to the AI service right now.";
        }
    }

}
