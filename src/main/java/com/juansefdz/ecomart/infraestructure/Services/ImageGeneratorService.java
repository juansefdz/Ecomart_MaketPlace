package com.juansefdz.ecomart.infraestructure.Services;

import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImageOptionsBuilder;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.stereotype.Service;

@Service
public class ImageGeneratorService {

    private final ImageModel imageModel;

    public ImageGeneratorService(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public String generateImage(String prompt) {
        var options = ImageOptionsBuilder.builder()
                .withHeight(1024)
                .withWidth(1024)
                .build();

        var response = imageModel.call(new ImagePrompt(prompt, options));

        return response.getResult().getOutput().getUrl();
    }
}
