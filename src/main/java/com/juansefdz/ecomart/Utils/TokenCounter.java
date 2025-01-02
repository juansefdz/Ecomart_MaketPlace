package com.juansefdz.ecomart.Utils;

import com.knuddels.jtokkit.Encodings;
import com.knuddels.jtokkit.api.ModelType;
import org.springframework.stereotype.Component;

@Component
public class TokenCounter {

    public int countTokens(String text, ModelType modelType) {
        var registry = Encodings.newDefaultEncodingRegistry();
        var encoder = registry.getEncodingForModel(modelType);
        return encoder.countTokens(text);
    }
}