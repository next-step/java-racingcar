package racingcar;

import java.util.Random;

public class RacingCar {

    private final Car[] cars;
    private final int attemptCount;

    public RacingCar(Car[] cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void race() {
        System.out.println("실행 결과");
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
        Random random = new Random();

        for (int j = 0; j < cars.length; j++) {
            int value = random.nextInt(10);
            Car car = cars[j];
            if (value >= 4) {
                car.moveForward();
            }
        }
    }


}
