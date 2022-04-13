package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class TracksHistory {

    private final List<Tracks> history;

    private TracksHistory(List<Tracks> history) {
        Assert.notEmpty(history, "'history' must not empty");
        this.history = new ArrayList<>(history);
    }

    public static TracksHistory from(List<Tracks> history) {
        return new TracksHistory(history);
    }

    int size() {
        return history.size();
    }

    public List<Tracks> list() {
        return Collections.unmodifiableList(history);
    }

    public Tracks lastFarthestTracks() {
        return new LinkedList<>(history).getLast()
                .farthestTracks();
    }

    @Override
    public String toString() {
        return "TracksHistory{" +
                "history=" + history +
                '}';
    }
}
