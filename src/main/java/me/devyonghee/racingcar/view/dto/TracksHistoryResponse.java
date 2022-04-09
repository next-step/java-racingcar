package me.devyonghee.racingcar.view.dto;

import me.devyonghee.racingcar.model.Distance;
import me.devyonghee.racingcar.model.Track;
import me.devyonghee.racingcar.model.Tracks;
import me.devyonghee.racingcar.model.TracksHistory;

import java.util.List;
import java.util.stream.Collectors;

public final class TracksHistoryResponse {

    private final List<List<Integer>> distancesHistory;

    public TracksHistoryResponse(List<List<Integer>> distancesHistory) {
        this.distancesHistory = distancesHistory;
    }

    public static TracksHistoryResponse from(TracksHistory history) {
        return new TracksHistoryResponse(history.list()
                .stream()
                .map(Tracks::list)
                .map(TracksHistoryResponse::distances)
                .collect(Collectors.toList())
        );
    }

    private static List<Integer> distances(List<Track> tracks) {
        return tracks.stream()
                .map(Track::distance)
                .map(Distance::value)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getDistancesHistory() {
        return distancesHistory;
    }
}
