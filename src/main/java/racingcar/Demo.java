package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        InputView.input();
        RacingGame racingGame = new RacingGame(InputView.getTimes());

        List<Car> cars = new ArrayList<>();
        for (int i = 1; i <= InputView.getNumOfCars(); i++) {
            cars.add(new Car());
        }

        OutputView.printIntroduction();
        List<Integer> result;
        for (int i = 1; i <= racingGame.getTimes(); i++) {
            result = racingGame.race(cars, new RandomNumberGenerator());
            OutputView.printResult(result);
        }
    }
}
