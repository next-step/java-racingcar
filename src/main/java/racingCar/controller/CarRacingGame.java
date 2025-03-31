package racingCar.controller;

import racingCar.domain.*;
import racingCar.view.InputView;
import racingCar.view.ResultView;

import java.util.*;

public class CarRacingGame {
    public static void main(String[] args) {
        CarNames carNames = InputView.getCarNamesFromUser();
        int rounds = InputView.getRoundsCountFromUser();

        Cars cars = CarFactory.createCars(carNames);

        RandomMoveStrategy randomMoveCondition = new RandomMoveStrategy(new Random());

        RacingGame racingGame = new RacingGame(cars,randomMoveCondition);
        for(int i=0; i<rounds; i++) {
            List<RoundStatusDTO> roundStatuses = racingGame.playRound();
            ResultView.printStatus(roundStatuses);
            ResultView.printEmptyLine();
        }

        List<RoundStatusDTO> winners = racingGame.findWinners();
        ResultView.printWinners(winners);
    }
}
