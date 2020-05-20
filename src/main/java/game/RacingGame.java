package game;

import game.ui.RacingGameInputView;
import game.ui.RacingGameResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    private final MovePolicy movePolicy;
    private final RacingGameInputView racingGameInputView;
    private final RacingGameResultView racingGameResultView;

    public RacingGame(MovePolicy movePolicy, RacingGameInputView racingGameInputView, RacingGameResultView racingGameResultView) {
        this.movePolicy = movePolicy;
        this.racingGameInputView = racingGameInputView;
        this.racingGameResultView = racingGameResultView;
    }

    public void play() {
        int numberOfCar = racingGameInputView.getNumberOfCar();
        int time = racingGameInputView.getTime();
        List<Car> carList = new ArrayList<>();
        IntStream.range(0, numberOfCar).forEach(i -> carList.add(new Car(0, movePolicy)));

        for (int i = 0; i < time; i++) {
            racingGameResultView.printRound(i+1);
            carList.forEach(Car::move);
            carList.forEach(car -> racingGameResultView.printResult(car.getPosition()));
        }

    }
}
