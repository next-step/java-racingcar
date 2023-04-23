package step3.domain;

import java.util.*;

public class Racecourse {
    private final TrackCollection trackCollection;

    public Racecourse(List<Track> tracks) {
        this.trackCollection = new TrackCollection(tracks);
    }

    public void signalToForward() {
        trackCollection.signalToForward();
    }

    public void enter(RacingCar racingCar) {
        trackCollection.findEmptyTrack().ifPresentOrElse(track -> track.enter(racingCar), () -> {
            throw new IllegalArgumentException("빈 track이 존재하지 않습니다.");
        });
    }

    public void enter(Collection<RacingCar> racingCars) {
        racingCars.forEach(this::enter);
    }

    public List<Track> tracks() {
        return trackCollection.copyToList();
    }

    public List<RacingCar> findTopRank() {
        final Position mostAdvancedRacingCarPosition = trackCollection.findMostAdvancedRacingCarPosition();
        return trackCollection.findRacingCarsByPosition(mostAdvancedRacingCarPosition);
    }
}
