package racingcar.controller;

import java.util.List;

import racingcar.domain.MoveCondition;
import racingcar.domain.MoveConditionGenerator;
import racingcar.domain.RacingCarWinnerSelector;
import racingcar.domain.RacingCars;
import racingcar.dto.RacingCarPrintDTO;
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
            PrintView.printRacingCarPrintRecords(RacingCarPrintDTO.fromRacingCars(racingCars));
        }

        RacingCars winners = RacingCarWinnerSelector.selectWinners(racingCars);
        PrintView.printRacingCarWinnerResult(winners.getAllNames());
    }

    public static void main(String[] args) {
        int tryCount = InputView.initTryCount();
        String[] racingCarNames = InputView.initRacingCarNames();
        RacingCars racingCars = RacingCars.from(racingCarNames);
        RacingGame.gameStart(racingCars, tryCount);
    }
}