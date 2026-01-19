package com.aipulse.aipulsemedia.model;

import java.time.LocalDateTime;

public class NewsSignal {
    private String title;
    private String summary;
    private String context;
    private String sourceURL;
    private LocalDateTime publishedAt;

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContext() {
        return context;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public NewsSignal(String title, String summary, String context, String sourceURL, LocalDateTime publishedAt) {
        this.title = title;
        this.summary = summary;
        this.context = context;
        this.sourceURL = sourceURL;
        this.publishedAt = publishedAt;


    }
}
