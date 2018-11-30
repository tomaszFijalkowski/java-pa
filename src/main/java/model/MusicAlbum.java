package model;

import model.interfaces.Listenable;

import java.util.Date;

public class MusicAlbum extends MediaItem implements Listenable {
    private double length;

    public MusicAlbum(String title, String author, Date releaseDate, boolean availability, double length) {
        super(title, author, releaseDate, availability);
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void listenTo() {

    }
}
