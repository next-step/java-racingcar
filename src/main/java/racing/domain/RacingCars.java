package racing.domain;

import java.util.ArrayList;
import java.util.List;

public final class RacingCars {

    public static final int MOVE_CONDITION = 4;

    private final List<Car> cars;

    public RacingCars(final String delimitedCarNames) {
        this.cars = new ArrayList<>();
        ready(delimitedCarNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void ready(final String delimitedCarNames) {
        String[] carNames = delimitedCarNames.split(",");
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void race(final Roulette roulette) {
        cars.stream()
                .filter(car -> canMove(roulette))
                .forEach(Car::move);
    }

    private boolean canMove(final Roulette roulette) {
        return roulette.spin() >= MOVE_CONDITION;
    }
}
