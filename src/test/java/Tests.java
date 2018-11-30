import controller.Manager;
import controller.User;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistance.MediaLibrary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

class Tests {

    private User user;
    private Manager manager;
    private MediaLibrary mediaLibrary;
    private MusicAlbum musicAlbum;
    private Book book;
    private Film film;

    @BeforeEach
    void prepareData() {
        book = new Book("Book Title Example", "Author Example 1", new Date(2018), true, 500);
        film = new Film("Film Example", "Author Example 2", new Date(2014), false, 90);
        musicAlbum = new MusicAlbum("Music Album Example", "Author Example 3", new Date(2016), true, 45);

        mediaLibrary = new MediaLibrary();
        mediaLibrary.addMediaItem(book);
        mediaLibrary.addMediaItem(film);
        mediaLibrary.addMediaItem(musicAlbum);

        user = new User(mediaLibrary);
        manager = new Manager(mediaLibrary);
    }

    @Test
    void checkIfUserCanRentAnAvailableItem() {
        final int userRentalListAfterRent = 1;
        user.rentItem(book);

        assertFalse(book.isAvailable());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    void checkIfUserCanNotRentAnUnAvailableItem() {
        final int userRentalListAfterRent = 0;
        user.rentItem(film);

        assertFalse(film.isAvailable());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    void checkIfUserCanReturnAnItem() {
        final int userRentalListAfterRent = 0;
        user.rentItem(musicAlbum);
        user.returnItem(musicAlbum);

        assertTrue(musicAlbum.isAvailable());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    void checkIfManagerCanRemoveItems() {
        final int mediaLibrarySizeAfterRemovingItem = 2;
        manager.removeItemFromLibrary(book);

        assertEquals(mediaLibrarySizeAfterRemovingItem, mediaLibrary.getMediaItemsData().size());
    }

    @Test
    void checkIfManagerCanAddItems() {
        final int mediaLibrarySizeAfterAddingItem = 4;
        manager.addItemToLibrary(new Book("New Book Title Example", "Author Example 4", new Date(2016), true, 400));

        assertEquals(mediaLibrarySizeAfterAddingItem, mediaLibrary.getMediaItemsData().size());
    }

    // Check for null values

    @Test
    void checkIfUserCanRentNull() {
        final int userRentalListAfterRent = 0;
        user.rentItem(null);

        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    void checkIfUserCanReturnNull() {
        final int userRentalListAfterRent = 1;
        user.rentItem(musicAlbum);
        user.returnItem(null);

        assertFalse(musicAlbum.isAvailable());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    void checkIfManagerCanRemoveNull() {
        final int mediaLibrarySizeAfterRemovingItem = 3;
        manager.removeItemFromLibrary(null);

        assertEquals(mediaLibrarySizeAfterRemovingItem, mediaLibrary.getMediaItemsData().size());
    }

    @Test
    void checkIfManagerCanAddNull() {
        final int mediaLibrarySizeAfterAddingItem = 3;
        manager.addItemToLibrary(null);

        assertEquals(mediaLibrarySizeAfterAddingItem, mediaLibrary.getMediaItemsData().size());
    }


}
