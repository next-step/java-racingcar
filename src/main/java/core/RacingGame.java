package core;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RacingGame {

    private Cars cars;

    public RacingGame(String[] carNames) {
        createCarList(carNames);
    }

    public Cars createCarList(String[] carNames) {
        cars = new Cars(carNames);
        return cars;
    }

    void startGame(int round) {
        IntStream.range(0,round).forEach(i -> startRound());
        ResultView.printWinnersName(cars);
    }

    void startRound() {
        cars.startRound(new RandomNumberMoveStrategy());
        ResultView.printRoundResult(cars);
    }

    public static void main(String args[]) {
        String[] carNames = InputView.getNamesOfCars();
        int round = InputView.getRound();
        RacingGame racingGame = new RacingGame(carNames);
        racingGame.startGame(round);
    }
}


