package controller;

import model.MediaItem;
import persistance.MediaLibrary;

public class Manager {

    public Manager(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    private MediaLibrary mediaLibrary;

    public void addItemToLibrary(MediaItem item) {
        if (item == null){
            return;
        }

        mediaLibrary.addMediaItem(item);
    }

    public void removeItemFromLibrary(MediaItem item) {
        if (item == null){
            return;
        }

        mediaLibrary.removeMediaItem(item);
    }

    public void editMediaItem(MediaItem item) {

    }
}
