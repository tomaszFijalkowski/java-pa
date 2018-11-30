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

public class Tests {

    User user;
    Manager manager;
    MediaLibrary mediaLibrary;
    MusicAlbum musicAlbum;
    Book book;
    Film film;

    @BeforeEach
    public void prepareData(){
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
    public void checkIfUserCanRentAnAvailableItem(){
        final int userRentalListAfterRent = 1;
        user.rentItem(book);

        assertFalse(book.isAvailability());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    public void checkIfUserCanNotRentAnUnAvailableItem(){
        final int userRentalListAfterRent = 0;
        user.rentItem(film);

        assertFalse(film.isAvailability());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());
    }

    @Test
    public void checkIfUserCanReturnAnItem(){
        final int userRentalListAfterRent = 0;
        user.rentItem(musicAlbum);
        user.returnItem(musicAlbum);

        assertTrue(musicAlbum.isAvailability());
        assertEquals(userRentalListAfterRent, user.getRentedItems().size());

    }

    @Test
    public void checkIfManagerCanRemoveItems(){
        final int mediaLibrarySizeAfterRemovingItem = 2;

        manager.removeItemFromLibrary(book);
        assertEquals(mediaLibrarySizeAfterRemovingItem, mediaLibrary.getMediaItemsData().size());
    }

    @Test
    public void checkIfManagerCanAddItems(){
        final int mediaLibrarySizeAfterAddingItem = 4;

        manager.addItemToLibrary(new Book("New Book Title Example", "Author Example 4", new Date(2016), true, 400));

        assertEquals(mediaLibrarySizeAfterAddingItem, mediaLibrary.getMediaItemsData().size());
    }
}
