package racingcar.domain;

import racingcar.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private int time;
    private List<Car> cars = new ArrayList<>();
    private ResultView resultView = new ResultView();

    public RacingGame(int carCount, int time) {
        for (int car = 0; car < carCount; car++) {
            this.cars.add(new Car(1));
        }
        this.time = time;
    }

    public void play() {
        for(int round = 0; round < time; round++) {
            playRound();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
            resultView.printPosition(car.getPosition());
        }
        resultView.print("");
    }
}
