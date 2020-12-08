package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingRound {

    private static final String RACING_CAR_EMPTY_MESSAGE = "참가한 자동차 리스트가 비었습니다.";
    private final List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<String> getWinners() {
        final RacingCar maxPositionCar = findMaxPositionCar();
        return findSamePositionCars(maxPositionCar);
    }

    private RacingCar findMaxPositionCar() {
        return racingCars.stream()
                .max(RacingCar::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(RACING_CAR_EMPTY_MESSAGE));
    }

    private List<String> findSamePositionCars(RacingCar maxPositionCar) {
        return racingCars.stream()
                .filter(maxPositionCar::isSamePosition)
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingRound that = (RacingRound) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }

}
