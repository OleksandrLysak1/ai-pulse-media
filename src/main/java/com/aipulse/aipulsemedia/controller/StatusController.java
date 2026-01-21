package com.aipulse.aipulsemedia.controller;

import com.aipulse.aipulsemedia.model.NewsSignal;
import com.aipulse.aipulsemedia.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class StatusController {

    private final NewsService newsService;

    public StatusController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/api/v1/status")
    public NewsSignal getStatus() {
        return newsService.generateStatusSignal();

    }

    @PostMapping("/api/v1/analyze")
    public NewsSignal analyzeNews(@RequestParam String title, @RequestParam String text) {
        return newsService.processRawNews(title, text);
    }

    @GetMapping("/api/v1/history")
    public List<NewsSignal> getHistory() {
        return newsService.getAllHistory();
    }

    @DeleteMapping("/api/v1/history")
    public String deleteHistory() {
        newsService.clearHistory();
        return "Історію успішно очищено!";
    }
}