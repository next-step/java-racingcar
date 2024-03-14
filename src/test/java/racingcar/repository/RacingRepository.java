package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RacingRepository {
    public List<Car> cars;

    private final int GO_CONDITION = 4;
    private final int GO_CONDITION_START_INDEX = 0;
    private final int GO_CONDITION_END_INDEX = 9;

    private static final String display = "-";

    private int totalTry;


    public int getTotalTry() {
        return totalTry;
    }


    public void makeCars(int input) {
        cars = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            cars.add(new Car());
        }
    }


    public void moveCar() {
        for (Car car : cars) {
            if (stopOrGo()) {
                car.move();
            }
        }
    }

    public void totalTry(int cnt) {
        this.totalTry = cnt;
    }


    private boolean stopOrGo() {
        return ThreadLocalRandom.current().nextInt(GO_CONDITION_START_INDEX, GO_CONDITION_END_INDEX) >= GO_CONDITION;
    }

    public void position() {
        for (Car car : cars) {
            for (int i = 0; i < car.location(); i++) {
                System.out.print(display);
            }
            System.out.println();
        }
    }
}
