package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Racecourse {
    private final List<Track> tracks = new ArrayList<>();

    public Racecourse(List<Track> tracks) {
        this.tracks.addAll(tracks);
        sortTracks();
    }

    public void signalToForward() {
        tracks.forEach(Track::signalToForward);
    }

    public void enter(RacingCar racingCar) {
        findEmptyTrack()
                .ifPresentOrElse(track -> track.enter(racingCar), () -> {
                            throw new IllegalArgumentException("빈 track이 존재하지 않습니다.");
                        }
                );
    }

    private Optional<Track> findEmptyTrack() {
        return tracks.stream().filter(Track::isEmpty).findFirst();
    }

    private void sortTracks() {
        tracks.sort(Track::compareTo);
    }

    public List<Track> tracks() {
        return List.copyOf(tracks);
    }
}
