package model;

import model.interfaces.Readable;

import java.util.Date;

public class Magazine extends MediaItem implements Readable {

    private String subject;

    public Magazine(String title, String author, Date releaseDate, boolean availability, String subject) {
        super(title, author, releaseDate, availability);
        this.subject = subject;
    }

    public String getSubject() {
        return subject != null ? subject : "none";
    }

    public void read() {

    }
}
