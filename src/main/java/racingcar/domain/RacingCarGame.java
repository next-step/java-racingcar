package racingcar.domain;

import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class RacingCarGame {

    private int numberOfTimes;
    private RacingCars racingCars;

    public void start(String carNameText, int numberOfTimes) {
        this.racingCars = new RacingCars(carNameText);
        this.numberOfTimes = numberOfTimes;
    }

    public void play() {
        IntStream.range(0, numberOfTimes).forEach(a -> {
            racingCars.race();
            OutputView.printRacing(racingCars.showCars());
        });
    }

}
