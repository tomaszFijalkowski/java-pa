package controller;

import model.MediaItem;
import persistance.MediaLibrary;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<MediaItem> rentedItems = new ArrayList<MediaItem>();
    private MediaLibrary mediaLibrary;

    public User(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public void preview(MediaItem item) {
        System.out.println("Item title: " + item.getTitle());
        System.out.println("Item author: " + item.getAuthor());
        System.out.println("Item release date: " + item.getReleaseDate());
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
        if (checkAvailability(item)) {
            item.setAvailability(false);
            rentedItems.add(item);
        }
    }

    public void returnItem(MediaItem item) {
        item.setAvailability(true);
        rentedItems.remove(item);
    }

    public List<MediaItem> getRentedItems() {
        return rentedItems;
    }

    private boolean checkAvailability(MediaItem item) {
        return item.isAvailability();
    }
}
