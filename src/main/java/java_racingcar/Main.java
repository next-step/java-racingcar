package java_racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int carNumber = InputView.inputCarNumber();
        int racingTime = InputView.inputRacingTime();

        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNumber; i++) {
            cars.add(new Car());
        }

        Random random = new Random();
        for (int i = 0; i < racingTime; i++) {
            for (Car car : cars) {
                int randomNumber = random.nextInt(8) + 1;
                car.race(randomNumber);
            }
        }
    }
}
