package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.domain.DefaultRandomService;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomService;
import racingcar.dto.TotalRacingGameResult;
import racingcar.service.RacingCarService;
import racingcar.view.OutputView;
import racingcar.view.WinnerUtils;

public class RacingGameController {
    private final OutputView outputView;

    public RacingGameController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run(List<String> carNames, PositiveNumber numberOfAttempts) {
        startAllGames(createRacingCars(carNames), createNumberOfAttempts(numberOfAttempts));
    }

    private RacingCars createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }

    private NumberOfAttempts createNumberOfAttempts(PositiveNumber numberOfAttempts) {
        return new NumberOfAttempts(numberOfAttempts.getNumber());
    }

    private void startAllGames(RacingCars racingCars, NumberOfAttempts numberOfAttempts) {
        outputView.printGameResultMessage();
        RacingCarService racingCarService = new RacingCarService(createRandomService(), racingCars, numberOfAttempts);
        TotalRacingGameResult totalRacingGameResult = racingCarService.startGame();
        outputView.printGameResult(totalRacingGameResult.getGameResults());
        outputView.printWinners(WinnerUtils.inform(totalRacingGameResult.getWinners()));
    }

    private RandomService createRandomService() {
        return new DefaultRandomService(new Random());
    }
}
