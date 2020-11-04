package racing;

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
        for (final Car car : this.cars) {
            boolean canMove = (roulette.spin() >= MOVE_CONDITION);
            car.move(canMove);
        }
    }
}
