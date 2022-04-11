package step4;

import car.CarRacing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {
    private List<Car> cars;

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public void play(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            for (Car car : cars) {
                car.move(Dice.roll());
                car.print();
            }
            System.out.println();
        }
    }

    public List<Car> finish() {
        int max = getMaxDistance();
        List<Car> winners = getWinners(max);
        return winners;
    }

    private int getMaxDistance() {
        int max = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (max < car.getDistance().length()) {
                max = car.getDistance().length();
            }
        }
        return max;
    }

    private List<Car> getWinners(int max) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (max == car.getDistance().length()) {
                winners.add(car);
            }
        }

        return winners;
    }
}
