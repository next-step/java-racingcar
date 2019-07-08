package racing.domain;

import java.util.List;

public class RacingGameResult {
    private final List<TrackResult> tracks;
    private final List<Car> winners;

    public RacingGameResult(List<TrackResult> tracks, List<Car> winners) {
        this.tracks = tracks;
        this.winners = winners;
    }

    public List<TrackResult> getTracks() {
        return tracks;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
