package org.springframework.samples.ai.ollama.rag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RagController {

    private final RagService ragService;

    public RagController(RagService ragService) {
        this.ragService = ragService;
    }

    @GetMapping("/ai/rag")
    public org.springframework.ai.chat.Generation generate(
            @RequestParam(value = "message", defaultValue = "What bike is good for city commuting?") String message) {
        return ragService.retrieve(message);
    }
    
}
