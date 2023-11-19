package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;
import racingcar.view.RacingGameResult;

public class RacingGameController {

    private final RacingGame racingGame;
    private final RacingGameResult racingGameResult;
    private final OutputView outputView;

    public RacingGameController(RacingGame racingGame, RacingGameResult racingGameResult, OutputView outputView) {
        this.racingGame = racingGame;
        this.racingGameResult = racingGameResult;
        this.outputView = outputView;
    }

    public void run(List<String> carNames, PositiveNumber numberOfAttempts) {
        List<RacingCar> racingCars = createRacingCars(carNames);
        startAllGames(numberOfAttempts, racingCars);
    }

    private List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return racingCars;
    }

    private void startAllGames(PositiveNumber numberOfAttempts, List<RacingCar> racingCars) {
        outputView.printGameResultMessage();
        NumberOfAttempts leftNumberOfAttempts = new NumberOfAttempts(numberOfAttempts.getNumber());
        do {
            racingGame.startSingleGame(racingCars);
            outputView.printSingleGameResult(racingGameResult.create(racingCars));
            leftNumberOfAttempts.attempt();
        } while (leftNumberOfAttempts.existsLeftNumberOfAttempts());
    }
}
