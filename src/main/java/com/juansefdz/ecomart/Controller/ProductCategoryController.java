package com.juansefdz.ecomart.Controller;

import com.knuddels.jtokkit.api.ModelType;
import com.juansefdz.ecomart.Utils.TokenCounter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.ChatOptionsBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product-category")
public class ProductCategoryController {

    private final ChatClient chatClient;
    private final TokenCounter tokenCounter;

    public ProductCategoryController(ChatClient.Builder chatClientBuilder, TokenCounter tokenCounter) {
        this.chatClient = chatClientBuilder
                .defaultOptions(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o-mini")
                        .withTemperature(0.80)
                        .build())
                .build();
        this.tokenCounter = tokenCounter;
    }

    @GetMapping
    public String ProductCategorize(String product) {
        //prompt engineering
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

        var tokens = tokenCounter.countTokens(system + product, ModelType.GPT_4O_MINI);
        System.out.println(tokens);

        return this.chatClient.prompt()
                .system(system)
                .user(product)
                .options(ChatOptionsBuilder.builder()
                        .withModel("gpt-4o")
                        .withTemperature(0.80)
                        .build())
                .advisors(new SimpleLoggerAdvisor())
                .call()
                .content();
    }
}
