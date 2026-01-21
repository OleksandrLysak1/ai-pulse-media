package com.aipulse.aipulsemedia.service;

import com.aipulse.aipulsemedia.model.NewsSignal;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private final List<NewsSignal> newsHistory = new ArrayList<>();
    // Лічильник для ID
    private long idCounter = 1;

    public NewsSignal processRawNews(String rawTitle, String rawText) {
        if (rawText == null || rawText.isBlank()) {
            rawText = "Немає даних для аналізу";
        }

        String sentiment = "Neutral";
        if (rawText.toLowerCase().contains("успіх") || rawText.toLowerCase().contains("зростання")) {
            sentiment = "Positive";
        } else if (rawText.toLowerCase().contains("криза") || rawText.toLowerCase().contains("падіння")) {
            sentiment = "Negative";
        }

        String summary = rawText.length() > 60 ? rawText.substring(0, 60) + "..." : rawText;
        String context = "Аналітика (" + sentiment + ")";

        // Створюємо об'єкт, передаючи idCounter++ (використати і збільшити)
        NewsSignal newSignal = new NewsSignal(
                idCounter++,
                rawTitle,
                summary,
                context,
                "Internal Analysis",
                LocalDateTime.now(),
                0
        );

        newsHistory.add(newSignal);
        return newSignal;
    }

    public List<NewsSignal> getAllHistory() {
        return newsHistory;
    }

    // Новий метод для очищення історії (знадобиться для DELETE запиту)
    public void clearHistory() {
        newsHistory.clear();
        idCounter = 1; // Скидаємо лічильник
    }

    public NewsSignal generateStatusSignal() {
        return new NewsSignal(
                0, // ID для системного статусу
                "AiPulse Media Live",
                "Система працює через Service Layer",
                "Контекст отримано з сервісу",
                "http://test.com",
                LocalDateTime.now(),
                2500
        );
    }
}