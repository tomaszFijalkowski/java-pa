package controller;

import model.*;
import view.ItemInfoRenderer;

public class SystemController {

    public void preview(Film film) {
        showGeneralInfo(film);
        ItemInfoRenderer.showItemInfo(Label.LENGTH, String.valueOf(film.getLength()));
    }

    public void preview(Book book) {
        showGeneralInfo(book);
        ItemInfoRenderer.showItemInfo(Label.NUMBER_OF_PAGES, String.valueOf(book.getNumberOfPages()));
    }

    public void preview(MusicAlbum musicAlbum) {
        showGeneralInfo(musicAlbum);
        ItemInfoRenderer.showItemInfo(Label.LENGTH, String.valueOf(musicAlbum.getLength()));
    }

    public void preview(Game game) {
        showGeneralInfo(game);
        ItemInfoRenderer.showItemInfo(Label.AGE_RESTRICTION, String.valueOf(game.getAgeRestriction()));
    }

    public void preview(Magazine magazine) {
        showGeneralInfo(magazine);
        ItemInfoRenderer.showItemInfo(Label.LENGTH, String.valueOf(magazine.getSubject()));
    }

    private void showGeneralInfo(MediaItem item) {
        ItemInfoRenderer.showItemInfo(Label.TITLE, String.valueOf(item.getTitle()));
        ItemInfoRenderer.showItemInfo(Label.AUTHOR, String.valueOf(item.getAuthor()));
        ItemInfoRenderer.showItemInfo(Label.DATE, String.valueOf(item.getReleaseDate()));
    }
}
