package racinggame.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class RacingCars implements Iterable<RacingCar> {
    private final List<RacingCar> racingCars;

    private RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public static RacingCars create(final List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public RacingCars moves() {
        racingCars.forEach(RacingCar::move);
        return new RacingCars(racingCars);
    }

    public int size() {
        return racingCars.size();
    }

    public int getMaxPosition() {
        return stream()
            .mapToInt(RacingCar::currentPosition)
            .max()
            .orElse(0);
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return racingCars.iterator();
    }

    public Stream<RacingCar> stream() {
        return racingCars.stream();
    }
}
