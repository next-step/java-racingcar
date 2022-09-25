package racingcar.domain;

import racingcar.view.OutputView;

public class RacingCarGame {

    private int numberOfTimes;
    private Cars cars;

    public RacingCarGame() {
    }

    public void start(String carNameText, int numberOfTimes) {
        this.cars = new Cars(carNameText);
        this.numberOfTimes = numberOfTimes;
    }

    public void play() {
        cars.race();
        OutputView.showRacing(cars);
    }
}
