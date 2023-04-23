package step3.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TrackCollection {
    private final List<Track> tracks;

    public TrackCollection(List<Track> tracks) {
        this.tracks = new ArrayList<>(tracks);
        sort();
    }

    public List<Track> copyToList() {
        return List.copyOf(tracks);
    }

    public void sort() {
        tracks.sort(Track::compareTo);
    }

    public List<RacingCar> findRacingCarsByPosition(Position position) {
        return this.tracks.stream()
                .map(Track::getRacingCar)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .filter(racingCar -> racingCar.isAtPosition(position))
                .collect(Collectors.toList());
    }

     public Position findMostAdvancedRacingCarPosition() {
        return this.tracks.stream()
                .filter(track -> !track.isEmpty())
                .map(Track::carPosition)
                .max(Comparator.naturalOrder())
                .orElse(RacingCar.defaultPosition);
    }

    public Optional<Track> findEmptyTrack() {
        return tracks.stream().filter(Track::isEmpty).findFirst();
    }

    public void signalToForward() {
        tracks.forEach(Track::signalToForward);
    }

}
