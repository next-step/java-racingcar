package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class RacingCars {

    public static final String CAR_NAMES_DELIMITER = ",";

    public static final int MOVE_CONDITION = 4;

    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public RacingCars(final String delimitedCarNames) {
        this.cars = ready(delimitedCarNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(final Roulette roulette) {
        cars.stream()
                .filter(car -> canMove(roulette))
                .forEach(Car::move);
    }

    private List<Car> ready(final String delimitedCarNames) {
        String[] carNames = delimitedCarNames.split(CAR_NAMES_DELIMITER);

        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private boolean canMove(final Roulette roulette) {
        return roulette.spin() >= MOVE_CONDITION;
    }
}
