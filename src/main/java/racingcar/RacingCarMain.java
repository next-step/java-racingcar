package racingcar;

import racingcar.model.Car;
import racingcar.utils.NumberGenerator;

import static racingcar.view.InputView.*;

public class RacingCarMain {
    public static void main(String[] args) {
        int sizeOfCar = howManyCar();
        int tryCnt = howManyTry();

        Car[] cars = new Car[sizeOfCar];

        for (int i = 0; i < sizeOfCar; i++) {
            cars[i] = new Car();
        }

        for (int i = 0; i < tryCnt; i++) {
            for (int j = 0; j < sizeOfCar; j++) {
                int randomNumber = NumberGenerator.randomNumber();
                if (randomNumber >= 4) {
                    cars[j].move();
                }
                System.out.println(cars[j].showStatus());
            }
            System.out.println();
        }
    }
}
