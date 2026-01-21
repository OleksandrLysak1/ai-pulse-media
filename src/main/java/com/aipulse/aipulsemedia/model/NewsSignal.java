package com.aipulse.aipulsemedia.model;

import java.time.LocalDateTime;

public class NewsSignal {
    private long id;
    // Онови конструктор, щоб він приймав id першим параметром
    private String title;
    private String summary;
    private String context;
    private String sourceURL;
    private LocalDateTime publishedAt;
    private int views;

    public long getId() {
        return id;
    }

    public NewsSignal(long id) {
        this.id = id;
    }

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

    public int getViews() {
        return views;
    }

    public NewsSignal(long id, String title, String summary, String context, String sourceURL, LocalDateTime publishedAt, int views) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.context = context;
        this.sourceURL = sourceURL;
        this.publishedAt = publishedAt;
        this.views = views;
    }
}
