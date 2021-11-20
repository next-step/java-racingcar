package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<RacingCar> values;

    private RacingCars(List<RacingCar> values) {
        this.values = values;
    }

    private static void verify(List<RacingCar> values) {
        if (isNullOrEmpty(values)) {
            throw new IllegalArgumentException("최소 1대 이상의 자동차가 경주에 참여해야 합니다.");
        }
    }

    private static boolean isNullOrEmpty(List<RacingCar> values) {
        return Objects.isNull(values) || values.isEmpty();
    }

    public static RacingCars from(String[] names, MovingStrategy strategy) {
        List<RacingCar> values = Arrays.stream(names)
                .map(value -> new RacingCar(new Name(value), strategy))
                .collect(Collectors.toList());
        return from(values);
    }

    public static RacingCars from(List<RacingCar> values) {
        verify(values);
        return new RacingCars(Collections.unmodifiableList(values));
    }

    public RacingCars race() {
        return RacingCars.from(
                values.stream()
                        .map(RacingCar::move)
                        .collect(Collectors.toList())
        );
    }

    public List<Position> getPositions() {
        return values.stream()
                .map(RacingCar::getPosition)
                .collect(Collectors.toList());
    }

    public List<RacingCar> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
