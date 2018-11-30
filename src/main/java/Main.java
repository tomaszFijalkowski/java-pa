import controller.User;
import model.Book;
import model.Film;
import model.MusicAlbum;

import java.util.Date;

public class Main {
    public static void main(String[] args){

        MusicAlbum musicAlbum = new MusicAlbum("MusicAlbum Title Example", "Author Example 5", new Date(2016), false, 30);
        Book book = new Book("Book Title Example", "Author Example 6", new Date(2018), true, 200);
        Film film = new Film("Film Title Example", "Author Example 7", new Date(2016), false, 120);
        User user = new User(null);
        user.preview(musicAlbum);
        System.out.println();
        user.preview(book);
        System.out.println();
        user.preview(film);

    }
}
