package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.MoveCondition;
import racingcar.domain.MoveConditionGenerator;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class RacingGame {

    private RacingGame() {
    }

    private static void gameStart(RacingCars racingCars, int tryCount) {
        PrintView.printGameResultMessage();

        int size = racingCars.size();
        for (int i = 0; i < tryCount; i++) {
            List<MoveCondition> conditions = MoveConditionGenerator.getMoveConditions(size);
            racingCars.move(conditions);
            PrintView.printRacingCarPrintRecords(racingCars.getRacingCarPrintDTOs());
        }

        List<RacingCar> winners = racingCars.getWinners();
        List<String> winnerNames = winners.stream()
            .map(RacingCar::getName)
            .collect(Collectors.toList());

        PrintView.printRacingCarWinnerResult(winnerNames);
    }

    public static void main(String[] args) {
        int tryCount = InputView.initTryCount();
        String[] racingCarNames = InputView.initRacingCarNames();
        RacingCars racingCars = new RacingCars(racingCarNames);
        RacingGame.gameStart(racingCars, tryCount);
    }
}