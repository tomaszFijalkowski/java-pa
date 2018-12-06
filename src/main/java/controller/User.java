package controller;

import model.*;
import persistance.MediaLibrary;

import java.util.ArrayList;
import java.util.List;

public class User extends SystemController {
    MediaLibrary mediaLibrary;
    private List<MediaItem> rentedItems = new ArrayList<MediaItem>();

    public User(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public MediaItem search(MediaItem item) {
        MediaItem searchedItem = null;
        for (MediaItem mediaItem : mediaLibrary.getMediaItemsData()) {
            if (item == mediaItem) {
                searchedItem = mediaItem;
            }
        }
        return searchedItem;
    }

    public void rentItem(MediaItem item) {
        if (item == null) {
            return;
        }

        if (checkAvailability(item)) {
            item.setAvailability(false);
            rentedItems.add(item);
        }
    }

    public void returnItem(MediaItem item) {
        if (item == null) {
            return;
        }

        item.setAvailability(true);
        rentedItems.remove(item);
    }

    public List<MediaItem> getRentedItems() {
        return rentedItems;
    }

    private boolean checkAvailability(MediaItem item) {
        return item.isAvailable();
    }
}
