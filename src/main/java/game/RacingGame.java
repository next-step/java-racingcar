package game;

import game.ui.RacingGameInputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final MovePolicy movePolicy;
    private final RacingGameInputView racingGameInputView;

    public RacingGame(MovePolicy movePolicy, RacingGameInputView racingGameInputView) {
        this.movePolicy = movePolicy;
        this.racingGameInputView = racingGameInputView;
    }

    public void play() {
        int numberOfCar = racingGameInputView.getNumberOfCar();
        int time = racingGameInputView.getTime();
        List<Car> carList = new ArrayList<>();
        IntStream.range(0, numberOfCar).forEach(i -> carList.add(new Car(i, 0, movePolicy)));

        for (int i = 0; i < time; i++) {
            carList.forEach(Car::move);
        }
    }
}
