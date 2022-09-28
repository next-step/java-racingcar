package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.MoveCondition;
import racingcar.domain.MoveConditionGenerator;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.InputView;
import racingcar.view.PrintView;

public class RacingGame {

    private final RacingCars racingCars;
    private final int tryCount;

    public RacingGame(RacingCars racingCars, int tryCount) {
        this.racingCars = racingCars;
        this.tryCount = tryCount;
    }

    private void gameStart() {
        PrintView.printGameResultMessage();

        int size = racingCars.size();
        IntStream.range(0, tryCount).forEach(i -> {
            List<MoveCondition> moveConditions = MoveConditionGenerator.getMoveConditions(size);
            racingCars.move(moveConditions);
            PrintView.printRacingCarPrintRecords(racingCars.getRacingCarPrintDTOs());
        });

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
        RacingGame racingGame = new RacingGame(racingCars, tryCount);
        racingGame.gameStart();
    }
}