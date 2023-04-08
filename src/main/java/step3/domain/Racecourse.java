package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Racecourse {
    private List<Track> tracks = new ArrayList<>();

    public void addTrack(Track track) {
        tracks.add(track);
        tracks.sort(Track::compareTo);
    }

    public List<Track> tracks() {
        return tracks;
    }
}
