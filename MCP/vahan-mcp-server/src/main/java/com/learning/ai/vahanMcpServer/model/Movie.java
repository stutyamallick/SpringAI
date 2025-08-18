package com.learning.ai.vahanMcpServer.model;

public class Movie {

    private String title;
    private String director;
    private String actor;

    public Movie() {
    }

    public Movie(String title, String director, String actor) {
        this.title = title;
        this.director = director;
        this.actor = actor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
