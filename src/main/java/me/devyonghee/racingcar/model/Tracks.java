package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public final class Tracks {

    private final Collection<Track> tracks;

    private Tracks(Collection<Track> tracks) {
        Assert.notNull(tracks, "'tracks' must not be null");
        this.tracks = new ArrayList<>(tracks);
    }

    public static Tracks from(Collection<Track> tracks) {
        return new Tracks(tracks);
    }

    public int size() {
        return tracks.size();
    }

    public Tracks movedTracks() {
        return from(tracks.stream()
                .map(Track::movedTrack)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "tracks=" + tracks +
                '}';
    }
}
