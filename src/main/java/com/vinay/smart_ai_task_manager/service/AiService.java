package com.vinay.smart_ai_task_manager.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AiService {

    public String analyzeTask(String title, String description) {

        String prompt = "Analyze this task and suggest priority, category, and advice. "
                + "Title: " + title + ". "
                + "Description: " + description + ".";

        RestTemplate restTemplate = new RestTemplate();

        String requestBody =
                "{\"model\":\"llama3.2:1b\","
                        + "\"prompt\":\"" + prompt.replace("\"", "\\\"") + "\","
                        + "\"stream\":false}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        return restTemplate.postForObject(
                "http://localhost:11434/api/generate",
                entity,
                String.class
        );
    }
}