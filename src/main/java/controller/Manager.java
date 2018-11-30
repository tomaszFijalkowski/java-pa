package controller;

import model.MediaItem;
import persistance.MediaLibrary;

public class Manager {

    public Manager(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    private MediaLibrary mediaLibrary;

    public void addItemToLibrary(MediaItem item) {
        mediaLibrary.getMediaItemsData().add(item);
    }

    public void removeItemFromLibrary(MediaItem item) {
        mediaLibrary.getMediaItemsData().remove(item);
    }

    public void editMediaItem(MediaItem item) {
    }
}
