package me.devyonghee.racingcar.view.dto;

import me.devyonghee.racingcar.model.Track;
import me.devyonghee.racingcar.model.Tracks;
import me.devyonghee.racingcar.model.TracksHistory;

import java.util.List;
import java.util.stream.Collectors;

public final class TracksHistoryResponse {

    private final List<List<TrackHistoryResponse>> trackHistoryResponses;

    public TracksHistoryResponse(List<List<TrackHistoryResponse>> trackHistoryResponses) {
        this.trackHistoryResponses = trackHistoryResponses;
    }

    public static TracksHistoryResponse from(TracksHistory history) {
        return new TracksHistoryResponse(history.list()
                .stream()
                .map(Tracks::list)
                .map(TracksHistoryResponse::responses)
                .collect(Collectors.toList())
        );
    }

    private static List<TrackHistoryResponse> responses(List<Track> tracks) {
        return tracks.stream()
                .map(TrackHistoryResponse::from)
                .collect(Collectors.toList());
    }

    public List<List<TrackHistoryResponse>> getTrackHistoryResponses() {
        return trackHistoryResponses;
    }
}
