package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        InputView input = new InputView();
        ResultView result = new ResultView();

        int numberOfCars = input.userInput("자동차 대수는 몇 대 인가요?");
        int numberOfAttempts = input.userInput("시도할 회수는 몇 회 인가요?");

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < numberOfAttempts; i++) {
            for (Car car : cars) {
                car.moveOrNot(new Random().nextInt(10));
            }
            result.show(cars);
        }
    }
}
