package com.aipulse.aipulsemedia.controller;

import com.aipulse.aipulsemedia.model.NewsSignal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class StatusController {

    @GetMapping("/api/v1/status")
    public NewsSignal getStatus() {
        return new NewsSignal(
                "Тест my first project",
                "Працює",
                "Контекст",
                "http://test.com",
                LocalDateTime.now()
        );
    }
}