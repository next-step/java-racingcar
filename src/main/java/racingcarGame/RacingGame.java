package racingcarGame;

import racingcarGame.client.ResultView;
import racingcarGame.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static racingcarGame.client.InputView.scanCars;
import static racingcarGame.client.InputView.scanPlayCount;
import static racingcarGame.client.ResultView.showResult;
import static racingcarGame.client.ResultView.showWinner;


public class RacingGame {
    public static void main(String[] args) {
        List<Car> cars = readyCars();

        int playCount = scanPlayCount();

        ResultView.showGameResultTitle();

        for (var i = 0; i < playCount; i++) {
            play(cars);
            showResult(cars);
        }

        showWinner(findWinner(cars));
    }

    private static void play(List<Car> cars) {
        cars.forEach(car -> {
            int chosenNumber = car.pickRandomlyNumber();
            car.move(chosenNumber);
        });
    }

    public static String findWinner(List<Car> cars) {
        Collections.sort(cars, (o1, o2) -> o2.getPosition() - o1.getPosition());

        int highScore = cars.get(0).getPosition();

        return cars.stream()
                .filter(car -> highScore == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private static List<Car> readyCars() {
        List<Car> cars = new ArrayList<>();

        String[] carNames = scanCars();

        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(0, carNames[i]));
        }

        return cars;
    }
}
