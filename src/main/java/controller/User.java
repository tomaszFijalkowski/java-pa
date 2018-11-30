package controller;

import model.*;
import persistance.MediaLibrary;
import view.ItemInfoRenderer;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<MediaItem> rentedItems = new ArrayList<MediaItem>();
    private MediaLibrary mediaLibrary;

    public User(MediaLibrary mediaLibrary) {
        this.mediaLibrary = mediaLibrary;
    }

    public void preview(Film film) {
        getGeneralInfo(film);
        ItemInfoRenderer.showItemInfo(Label.LENGTH, String.valueOf(film.getLength()));
    }

    public void preview(Book book) {
        getGeneralInfo(book);
        ItemInfoRenderer.showItemInfo(Label.NUMBER_OF_PAGES, String.valueOf(book.getNumberOfPages()));
    }

    public void preview(MusicAlbum musicAlbum) {
        getGeneralInfo(musicAlbum);
        ItemInfoRenderer.showItemInfo(Label.LENGTH, String.valueOf(musicAlbum.getLength()));
    }

    private void getGeneralInfo(MediaItem item) {
        ItemInfoRenderer.showItemInfo(Label.TITLE, String.valueOf(item.getTitle()));
        ItemInfoRenderer.showItemInfo(Label.AUTHOR, String.valueOf(item.getAuthor()));
        ItemInfoRenderer.showItemInfo(Label.DATE, String.valueOf(item.getReleaseDate()));
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
        if (item == null){
            return;
        }

        if (checkAvailability(item)) {
            item.setAvailability(false);
            rentedItems.add(item);
        }
    }

    public void returnItem(MediaItem item) {
        if (item == null){
            return;
        }

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
