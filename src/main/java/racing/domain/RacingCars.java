package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class RacingCars {

    public static final String CAR_NAMES_DELIMITER = ",";

    public static final int MOVE_CONDITION = 4;

    private final List<Car> cars;

    public RacingCars(final List<Car> cars) {
        this.cars = cars;
    }

    public RacingCars(final String delimitedCarNames) {
        this.cars = new ArrayList<>();
        ready(delimitedCarNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void race(final Roulette roulette) {
        cars.stream()
                .filter(car -> canMove(roulette))
                .forEach(Car::move);
    }

    public List<String> getWinners() {
        Map<Integer, List<String>> rankings = new HashMap<>();

        for (Car car : cars) {
            List<Name> names =
                    rankings.computeIfAbsent(car.getPosition(), name -> new LinkedList<>());
            names.add(car.getName());
        }

        int maxDisplacement = Collections.max(rankings.keySet());

        return rankings.get(maxDisplacement);
    }

    private void ready(final String delimitedCarNames) {
        String[] carNames = delimitedCarNames.split(CAR_NAMES_DELIMITER);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    private boolean canMove(final Roulette roulette) {
        return roulette.spin() >= MOVE_CONDITION;
    }
}
