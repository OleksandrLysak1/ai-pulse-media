package com.aipulse.aipulsemedia.controller;

import com.aipulse.aipulsemedia.model.NewsSignal;
import com.aipulse.aipulsemedia.service.NewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}