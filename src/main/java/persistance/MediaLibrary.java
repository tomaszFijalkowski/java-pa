package persistance;

import model.MediaItem;

import java.util.ArrayList;
import java.util.List;

public class MediaLibrary {
    private List<MediaItem> mediaItemsData = new ArrayList<MediaItem>();

    public List<MediaItem> getMediaItemsData() {
        return mediaItemsData;
    }

    public void addMediaItem(MediaItem item) {
        mediaItemsData.add(item);
    }

    public void removeMediaItem(MediaItem item) {
        mediaItemsData.remove(item);
    }

    public void editMetaDataOfMediaItems() {

    }


}
