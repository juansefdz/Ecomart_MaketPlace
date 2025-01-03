package com.juansefdz.ecomart.infraestructure.Services;


import com.knuddels.jtokkit.api.ModelType;
import com.juansefdz.ecomart.Utils.TokenCounter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProductCategoryService {

    private final ChatClient chatClient;
    private final TokenCounter tokenCounter;

    public ProductCategoryService(ChatClient.Builder chatClientBuilder, TokenCounter tokenCounter) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o-mini")
                        .withTemperature(0.80)
                        .build())
                .build();
        this.tokenCounter = tokenCounter;
    }

    public String categorizeProduct(String product) {
        // prompt engineering
        var system = """
                acts as a product categorize,
                you only have to answer the name of the selected product category.
                
                choose one of the following categories:
                1. Electronics
                2. Clothing
                3. Home
                4. Beauty
                5. Sports
                6. Others
                
                use example:
                product: "smartphone"
                category: "Electronics"
                """;

        // Calcula tokens
        int tokens = tokenCounter.countTokens(system + product, ModelType.GPT_4O_MINI);
        System.out.println("Tokens used: " + tokens);

        // Genera respuesta
        return this.chatClient.prompt()
                .system(system)
                .user(product)
                .options(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o")
                        .withTemperature(0.80)
                        .build())
                .call()
                .content();
    }
}
