package step3.util;

import step3.domain.RacingCar;
import step3.domain.Track;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCreateHelper {
    private RacingCreateHelper() {
    }

    public static List<RacingCar> createRacingCars(List<String> carNames) {
        return carNames.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public static List<Track> createTracks(int amount) {
        return IntStream.range(0, amount)
                .mapToObj(Track::new)
                .collect(Collectors.toList());
    }
}
