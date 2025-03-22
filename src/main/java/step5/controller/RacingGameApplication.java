package step5.controller;

import step5.domain.*;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.List;
import java.util.Random;

public class RacingGameApplication {

    public static void main(String[] args) {
        play();
    }

    private static void play() {
        CarNames carNames = new CarNames(InputView.getCarNamesInput());
        int rounds = InputView.getRoundsInput();

        Cars cars = CarFactory.createCars(carNames);
        RandomMovingStrategy movingStrategy = new RandomMovingStrategy(new Random());

        RacingGame racingGame = new RacingGame(cars, movingStrategy);
        for (int round = 0; round < rounds; round++) {
            List<CarStatusDto> currentStatus = racingGame.playRound();
            ResultView.printRaceProgress(currentStatus);
        }

        List<CarStatusDto> winners = racingGame.winners();
        ResultView.printWinners(winners);
    }
}
