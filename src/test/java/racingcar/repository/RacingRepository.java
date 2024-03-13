package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RacingRepository {
    private List<Car> cars;

    private final int GO_CONDITION = 4;
    private final int GO_CONDITION_START_INDEX = 0;
    private final int GO_CONDITION_END_INDEX = 9;

    public void makeCars(int input) {
        cars = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            cars.add(new Car());
        }
    }

    public void moveCar(RacingRepository racingRepository) {

        for (Car car : racingRepository.cars) {
            if (stopOrGo()) car.move();
            car.position();
        }
    }

    private boolean stopOrGo() {
        return ThreadLocalRandom.current().nextInt(GO_CONDITION_START_INDEX, GO_CONDITION_END_INDEX) >= GO_CONDITION;
    }

}
