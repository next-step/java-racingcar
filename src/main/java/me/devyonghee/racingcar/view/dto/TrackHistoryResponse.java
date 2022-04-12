package me.devyonghee.racingcar.view.dto;

import me.devyonghee.racingcar.model.Track;

public final class TrackHistoryResponse {

    private final String name;
    private final int distance;

    private TrackHistoryResponse(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    static TrackHistoryResponse from(Track track) {
        return new TrackHistoryResponse(track.car().name().value(), track.distance().value());
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
