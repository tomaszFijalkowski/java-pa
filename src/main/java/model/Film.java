package model;

import model.interfaces.Listenable;
import model.interfaces.Watchable;

import java.util.Date;

public class Film extends MediaItem implements Listenable, Watchable {
    public double getLength() {
        return length;
    }

    public Film(String title, String author, Date releaseDate, boolean availability, double length) {
        super(title, author, releaseDate, availability);
        this.length = length;
    }

    public void watch() {

    }

    public void listenTo() {

    }

    private double length;
}
