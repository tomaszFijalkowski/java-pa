package controller;

import model.MediaItem;
import persistance.MediaLibrary;

public class Manager extends User{

    public Manager(MediaLibrary mediaLibrary) {
        super(mediaLibrary);
    }

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
