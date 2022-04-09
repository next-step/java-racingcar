package me.devyonghee.racingcar.model;

import me.devyonghee.racingcar.utility.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class TracksHistory {

    private final List<Tracks> history;

    private TracksHistory(List<Tracks> history) {
        Assert.notNull(history, "'history' must not be null");
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

    @Override
    public String toString() {
        return "TracksHistory{" +
                "history=" + history +
                '}';
    }
}
