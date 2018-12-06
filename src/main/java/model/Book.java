package model;

import model.interfaces.Readable;

import java.util.Date;

public class Book extends MediaItem implements Readable {
    private int numberOfPages;

    public Book(String title, String author, Date releaseDate, boolean availability, int numberOfPages) {
        super(title, author, releaseDate, availability);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void read() {

    }
}
