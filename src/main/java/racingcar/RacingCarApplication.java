package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCar;
import racingcar.view.InputView;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RacingCarApplication {


    public static void main(String[] args) {
        RacingCar racingCar = new RacingCar(createCars(InputView.readCarCount()), InputView.readAttemptCount());
        racingCar.race();
    }


    private static Car[] createCars(int count) {
        Car[] cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car();
        }
        return cars;
    }


}
