package step3.service;

import step3.domain.Car;
import step3.util.RandomValue;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame implements GameStrategy {

    private static final int RANDOM_BOUND = 10;

    private List<Car> cars = new ArrayList<>();

    public RacingCarGame(int count) {
        for (int i = 0; i < count; i++) {
            cars.add(new Car(new RacingCarForwardMatcher()));
        }
    }

    @Override
    public List<Car> playGame() {
        for (Car car : cars) {
            final int random = RandomValue.nextInt(RANDOM_BOUND);

            car.forward(random);
        }

        return this.cars;
    }
}
