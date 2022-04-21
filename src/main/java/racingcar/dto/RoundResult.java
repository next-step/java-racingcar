package racingcar.dto;

import racingcar.model.CarName;
import racingcar.model.Distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RoundResult {
    private final List<CarName> carNames;
    private final List<Distance> distances;
    private final int carsCount;

    private RoundResult(List<CarName> carNames, List<Distance> distances) {
        validate(carNames, distances);
        this.carNames = new ArrayList<>(carNames);
        this.distances = new ArrayList<>(distances);
        this.carsCount = carNames.size();
    }

    private void validate(List<CarName> carNames, List<Distance> distances) {
        Objects.requireNonNull(carNames, "RoundResult 에 전달된 리스트가 올바르지 않습니다 : carNames is null");
        Objects.requireNonNull(distances, "RoundResult 에 전달된 리스트가 올바르지 않습니다 : distances is null");

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("RoundResult 에 전달된 리스트가 올바르지 않습니다 : carNames is empty");
        }
        if (distances.isEmpty()) {
            throw new IllegalArgumentException("RoundResult 에 전달된 리스트가 올바르지 않습니다 : distances is empty");
        }
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public List<Distance> getDistances() {
        return Collections.unmodifiableList(distances);
    }

    public int getCarsCount() {
        return carsCount;
    }

    public static RoundResult of(List<CarName> carNames, List<Distance> distances) {
        return new RoundResult(carNames, distances);
    }
}
