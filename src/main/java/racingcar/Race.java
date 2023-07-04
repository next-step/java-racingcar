package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Car[] cars;
    private int leftRound;

    private Race(Car[] cars, int leftRound) {
        this.cars = cars;
        this.leftRound = leftRound;
    }

    public static Race of(Car[] cars, int count) {
        return new Race(cars, count);
    }

    public int getLeftRound() {
        return this.leftRound;
    }

    public void play(NumberGenerator numberGenerator) {
        startRound();
        for (Car car : cars) {
            if (RaceUtil.determineCarMovement(numberGenerator.generate())) {
                car.moveForward();
            }
        }
    }

    public String[] findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(car.getPosition(), maxPosition);
        }

        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            if (maxPosition == car.getPosition()) {
                names.add(car.getName());
            }
        }

        return names.toArray(String[]::new);
    }

    private void startRound() {
        this.leftRound--;
    }

    public Car[] getCars() {
        return this.cars;
    }
}
