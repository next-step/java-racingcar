package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RacingCar {

    private final Car[] cars;
    private final int attemptCount;

    public RacingCar(Car[] cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void race() {

        for (int i = 0; i < attemptCount; i++) {
            moveCar();
            printCurrentPosition();
        }
    }

    private void printCurrentPosition() {
        for (int j = 0; j < cars.length; j++) {
            int dis = cars[j].getPosition();
            for (int k = 0; k < dis; k++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    private void moveCar() {
        for (int j = 0; j < cars.length; j++) {
            if (moveStrategy()) {
                cars[j].moveForward();
            }
        }
    }

    public List<Integer> getPositions() {
        return Arrays.stream(cars).map(Car::getPosition).toList();
    }


    private boolean moveStrategy() {
        Random random = new Random();

        int randomNumber = random.nextInt(10);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }


}
