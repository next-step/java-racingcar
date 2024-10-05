package racinggame.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCars implements Iterable<RacingCar> {
    public static final int MIN_RACING_CAR_COUNT = 2;

    private final List<RacingCar> racingCars;

    private RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public static RacingCars create(final List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public RacingCars moves() {
        return new RacingCars(
            racingCars.stream()
                .map(RacingCar::move)
                .collect(Collectors.toList())
        );
    }

    public int size() {
        return racingCars.size();
    }

    public int getMaxPosition() {
        return stream()
            .mapToInt(RacingCar::currentPosition)
            .max()
            .orElseThrow(() -> new NoSuchElementException("움직인 개체가 존재하지 않습니다."));
    }

    @Override
    public Iterator<RacingCar> iterator() {
        return racingCars.iterator();
    }

    public Stream<RacingCar> stream() {
        return racingCars.stream();
    }
}
