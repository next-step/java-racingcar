package racingcar;

import racingcar.client.ResultView;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.client.InputView.scanCars;
import static racingcar.client.InputView.scanPlayCount;
import static racingcar.client.ResultView.showResult;
import static racingcar.client.ResultView.showWinner;


public class RacingGame {
    public static void main(String[] args) {
        Cars cars = new Cars(readyCars());

        int playCount = scanPlayCount();

        ResultView.showGameResultTitle();

        for (var i = 0; i < playCount; i++) {
            cars.moveCars();
            showResult(cars);
        }

        showWinner(cars.findWinner());
    }

    private static List<Car> readyCars() {
        return Arrays.stream(scanCars())
                .map(name -> new Car(0, name))
                .collect(Collectors.toList());
    }
}
