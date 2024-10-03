package racinggame.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static racinggame.domain.RacingGameRules.MIN_RACING_CAR_COUNT;

public class RacingCars implements Iterable<RacingCar> {
    private final List<RacingCar> racingCars;

    private RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public static RacingCars create(final List<RacingCar> racingCars) {
        if (racingCars.size() < MIN_RACING_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 " + MIN_RACING_CAR_COUNT + "대 이상이여야 합니다.");
        }

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
