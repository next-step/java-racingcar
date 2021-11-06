package step3;

import step3.domain.Car;
import step3.domain.RacingGame;
import step3.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingCarApplication {

    public static void main(String[] args) {
        int carCount = InputView.inputCarCount();
        int gameCount = InputView.inputGameRapCount();
        System.out.println();

        start(carCount, gameCount);
    }

    private static void start(int carCount, int gameCount) {
        RacingGame racingGame = RacingGame.create(gameCount, createCars(carCount));
        racingGame.start();
    }

    private static List<Car> createCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int count = 0; count < carCount; count++) {
            cars.add(Car.create());
        }
        return cars;
    }
}
