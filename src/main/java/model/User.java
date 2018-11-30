package model;

import persistance.MediaLibrary;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<MediaItem> rentedItems = new ArrayList();
    private MediaLibrary mediaLibrary;

    public void preview(MediaItem item) {
    }

    public MediaItem search(List<MediaItem> metaData) {
        return null;
    }

    public void rentItem(MediaItem item) {
    }

    public void returnItem(MediaItem item) {
    }

    public boolean checkAvailibility(MediaItem item) {
        return false;
    }
}
