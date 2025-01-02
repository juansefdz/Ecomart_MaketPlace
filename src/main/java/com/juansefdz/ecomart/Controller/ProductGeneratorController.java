package com.juansefdz.ecomart.Controller;

import com.juansefdz.ecomart.Utils.TokenCounter;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-generator")
public class ProductGeneratorController {

    private final ChatClient chatClient;
    private final TokenCounter tokenCounter;

    public ProductGeneratorController(ChatClient.Builder chatClientBuilder, TokenCounter tokenCounter) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o-mini")
                        .withTemperature(0.80)
                        .build())
                .build();
        this.tokenCounter = tokenCounter;
    }

    @GetMapping
    public String ProductGenerator() {
        var question = "Generate 5 ecological products";
        var systemPrompt = """
                You are a product generator focused on ecological products.
                Generate a list of products based on the user's request.
                """;


        int tokens = tokenCounter.countTokens(systemPrompt + question, ModelType.GPT_4O_MINI);
        System.out.println("Tokens used: " + tokens);


        return this.chatClient.prompt()
                .system(systemPrompt)
                .user(question)
                .call()
                .content();
    }
}
