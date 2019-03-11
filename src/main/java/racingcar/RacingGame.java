package racingcar;

import java.util.*;
import java.util.stream.IntStream;

public class RacingGame {
    public List<RacingCar> racingCars = new ArrayList<>();

    public static void main(String[] args) {
        InputView inputView = new InputView();
        new RacingGame(inputView.inputCarCount(), inputView.inputTryCount());
    }

    public RacingGame(int carCount, int tryCount) {
        if (carCount == 0) {
            return;
        }
        if (tryCount == 0) {
            return;
        }
        this.setCars(carCount);
        this.tryRacing(tryCount);
    }

    public void setCars(int carCount) {
        IntStream.range(0, carCount).forEach(i -> {
            this.racingCars.add(new RacingCar());
        });
    }

    public void tryRacing(int tryCount) {
        IntStream.range(0, tryCount).forEach(count -> {
                 this.moveCar();
        });
    }

    public void moveCar() {
        this.racingCars.forEach(racingCar -> {
            racingCar.move();
        });
        new ResultView().printResult(this.racingCars);
    }
}
