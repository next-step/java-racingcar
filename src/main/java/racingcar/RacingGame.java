package racingcar;

import java.util.*;
import java.util.stream.IntStream;

public class RacingGame {
    public InputView inputView = new InputView();
    public List<RacingCar> racingCars = new ArrayList<>();

    public static void main(String[] args) {
        new RacingGame().run();
    }

    public void run() {
        int carCount = this.inputView.inputCarCount();
        if (carCount == 0) {
            return;
        }

        int tryCount = this.inputView.inputTryCount();
        if (tryCount == 0) {
            return;
        }

        this.setCar(carCount);
        this.tryRacing(tryCount);
    }

    public void setCar(int carCount) {
        IntStream.range(0, carCount)
                 .forEach(car -> {
                     this.racingCars.add(new RacingCar());
                 });
    }

    public void tryRacing(int tryCount) {
        IntStream.range(0, tryCount)
             .forEach(count -> {
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
