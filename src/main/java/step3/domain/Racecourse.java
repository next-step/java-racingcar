package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Track> tracks() {
        return List.copyOf(tracks);
    }

    public List<RacingCar> findTopRank() {
        final int mostAdvancedRacingCarPosition = findMostAdvancedRacingCarPosition();
        return findRacingCarsByPosition(mostAdvancedRacingCarPosition);
    }

    private Integer findMostAdvancedRacingCarPosition() {
        return this.tracks.stream()
                .filter(track -> !track.isEmpty())
                .map(Track::carPosition)
                .max(Integer::compareTo)
                .orElse(RacingCar.defaultPosition);
    }

    private List<RacingCar> findRacingCarsByPosition(int position) {
        return this.tracks.stream()
                .map(Track::getRacingCar)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(racingCar -> racingCar.isAtPosition(position))
                .collect(Collectors.toList());
    }

    private Optional<Track> findEmptyTrack() {
        return tracks.stream().filter(Track::isEmpty).findFirst();
    }

    private void sortTracks() {
        tracks.sort(Track::compareTo);
    }
}
