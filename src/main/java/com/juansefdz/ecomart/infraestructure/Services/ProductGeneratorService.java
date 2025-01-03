package com.juansefdz.ecomart.infraestructure.Services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.stereotype.Service;


import com.juansefdz.ecomart.Utils.TokenCounter;
import com.knuddels.jtokkit.api.ModelType;

@Service
public class ProductGeneratorService {

    private final ChatClient chatClient;
    private final TokenCounter tokenCounter;

    public ProductGeneratorService(ChatClient.Builder chatClientBuilder, TokenCounter tokenCounter) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o-mini")
                        .withTemperature(0.80)
                        .build())
                .build();
        this.tokenCounter = tokenCounter;
    }

    public String generateProducts(String question) {
        var systemPrompt = """
                You are a product generator focused on ecological products.
                Generate a list of products based on the user's request.
                """;

        // Calcular tokens
        int tokens = tokenCounter.countTokens(systemPrompt + question, ModelType.GPT_4O_MINI);
        System.out.println("Tokens used: " + tokens);

        // Generar respuesta
        return this.chatClient.prompt()
                .system(systemPrompt)
                .user(question)
                .call()
                .content();
    }
}