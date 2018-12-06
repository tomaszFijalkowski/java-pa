package model;

import model.interfaces.Playable;

import java.util.Date;

public class Game extends MediaItem implements Playable {

    private int ageRestriction;

    public Game(String title, String author, Date releaseDate, boolean availability, int ageRestriction) {
        super(title, author, releaseDate, availability);
        this.ageRestriction = ageRestriction;
    }

    public int getAgeRestriction() {
        return ageRestriction;
    }

    public void play() {

    }
}
