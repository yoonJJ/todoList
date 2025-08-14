package com.example.todoList.domain;

public class Todo {
    private Long id;
    private String content;
    private boolean completed;

    public Todo() {
    }

    public Todo(Long id, String content, boolean completed) {
        this.id = id;
        this.content = content;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
