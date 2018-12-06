import controller.Manager;
import controller.SystemController;
import controller.User;
import model.Book;
import model.Film;
import model.Game;
import model.MusicAlbum;

import java.util.Date;

public class Main {
    public static void main(String[] args){

        // example of usage (preview method on User)
        MusicAlbum musicAlbum = new MusicAlbum("MusicAlbum Title Example", "Author Example 5", new Date(2016), false, 30);
        Book book = new Book("Book Title Example", "Author Example 6", new Date(2018), true, 200);
        Film film = new Film("Film Title Example", "Author Example 7", new Date(2016), false, 120);
        Game game = new Game("Game Title Example", "Author Example 8", new Date(2015), false, 16);
        User user = new User(null);
        User manager = new Manager(null);
        SystemController system = new SystemController();

        user.preview(musicAlbum);
        System.out.println();
        user.preview(book);
        System.out.println();
        manager.preview(film);
        System.out.println();
        system.preview(game);

    }
}
