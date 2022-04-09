package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Tracks {

    private final List<Track> tracks;

    private Tracks(List<Track> tracks) {
        Assert.notNull(tracks, "'tracks' must not be null");
        this.tracks = new ArrayList<>(tracks);
    }

    public static Tracks from(List<Track> tracks) {
        return new Tracks(tracks);
    }

    int size() {
        return tracks.size();
    }

    Tracks movedTracks() {
        return from(tracks.stream()
                .map(Track::movedTrack)
                .collect(Collectors.toList()));
    }

    public List<Track> list() {
        return Collections.unmodifiableList(tracks);
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "tracks=" + tracks +
                '}';
    }
}
