package racingcar;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;

public class RacingCarSystem {
    private int cars;
    private List<RacingCar> racingCars;
    private int movements;

    private static Random random = new Random();

    public void registerCar(int numberOfCar) {
        cars = numberOfCar;
        racingCars = new ArrayList<>();

        for (int i = 0; i < numberOfCar; i++) {
            racingCars.add(new RacingCar());
        }
    }

    public int getNumberOfCars() {
        return cars;
    }

    public void registerMovements(int movements) {
        this.movements = movements;
    }

    public int getMovements() {
        return movements;
    }

    public void goOrStop() {
        for (RacingCar car : racingCars) {
            car.drive(random());
        }
    }

    private static int random() {
        return random.nextInt(10);
    }

    public int[] getStatusOfCars() {
        return racingCars.stream().mapToInt(i -> i.getDistance()).toArray();
    }
}
