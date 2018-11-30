package model;

import java.util.Date;

abstract public class MediaItem {
    private String title;
    private String author;
    private Date releaseDate;
    private boolean availability;

    MediaItem(String title, String author, Date releaseDate, boolean availability) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
