package racing.domain;

import java.util.ArrayList;
import java.util.List;

public final class RacingCars {

    public static final int MOVE_CONDITION = 4;

    private final List<Car> cars;

    public RacingCars(final int carCount) {
        this.cars = new ArrayList<>();
        ready(carCount);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void ready(int carCount) {
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public void race(Roulette roulette) {
        cars.stream()
                .filter(car -> canMove(roulette))
                .forEach(Car::move);
    }

    private boolean canMove(Roulette roulette) {
        return roulette.spin() >= MOVE_CONDITION;
    }
}
