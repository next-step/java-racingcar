package core;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingGame {

    static Cars cars;

    RacingGame(String[] carNames) {
        createCarList(carNames);
    }

    public static Cars createCarList(String[] carNames) {
        cars = Cars.create(new ArrayList<>());
        Arrays.stream(carNames).forEach(carName -> cars.addCar(Car.create(carName)));
        return cars;
    }

    void startGame(int round) {
        IntStream.range(0,round).forEach(i -> startRound());
        ResultView.printWinnersName(cars);
    }

    void startRound() {
        ResultView.printRoundResult(Cars.startRound(cars));
    }

    public static void main(String args[]) {
        InputView.getInputValue();
        RacingGame racingGame = new RacingGame(GameSettings.carNames);
        racingGame.startGame(GameSettings.round);
    }

}


