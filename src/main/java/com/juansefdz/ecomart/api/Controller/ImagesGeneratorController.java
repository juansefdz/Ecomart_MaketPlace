package com.juansefdz.ecomart.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juansefdz.ecomart.infraestructure.Services.ImageGeneratorService;

@RestController
@RequestMapping("/image-generator")
public class ImagesGeneratorController {

    private final ImageGeneratorService imageGeneratorService;

    public ImagesGeneratorController(ImageGeneratorService imageGeneratorService) {
        this.imageGeneratorService = imageGeneratorService;
    }

    @GetMapping
    public String generateImage(@RequestParam String prompt) {
        return imageGeneratorService.generateImage(prompt);
    }
}
