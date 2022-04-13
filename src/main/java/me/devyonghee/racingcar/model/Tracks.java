package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class Tracks {

    private static final Comparator<Track> TRACK_DISTANCE_COMPARATOR = (track1, track2) -> {
        if (track1.distanceGreaterThan(track2)) {
            return 0;
        }
        return -1;
    };

    private final List<Track> tracks;

    private Tracks(List<Track> tracks) {
        Assert.notEmpty(tracks, "'tracks' must not empty");
        this.tracks = new ArrayList<>(tracks);
    }

    public static Tracks from(List<Track> tracks) {
        return new Tracks(tracks);
    }

    public List<Track> list() {
        return Collections.unmodifiableList(tracks);
    }

    Tracks farthestTracks() {
        Track farthestTrack = farthestTrack();
        return Tracks.from(tracks.stream()
                .filter(track -> track.equalDistance(farthestTrack))
                .collect(Collectors.toList()));
    }

    int size() {
        return tracks.size();
    }

    Tracks movedTracks() {
        return from(tracks.stream()
                .map(Track::movedTrack)
                .collect(Collectors.toList()));
    }

    private Track farthestTrack() {
        return tracks.stream()
                .max(TRACK_DISTANCE_COMPARATOR)
                .orElseThrow(() -> new IllegalStateException("an error occurred while finding longest distance track"));
    }

    @Override
    public String toString() {
        return "Tracks{" +
                "tracks=" + tracks +
                '}';
    }
}
