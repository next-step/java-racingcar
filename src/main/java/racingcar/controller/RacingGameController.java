package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.Winner;
import racingcar.view.OutputView;
import racingcar.view.RacingGameResult;

public class RacingGameController {

    private final RacingGame racingGame;
    private final RacingGameResult racingGameResult;
    private final Winner winner;
    private final OutputView outputView;

    public RacingGameController(RacingGame racingGame, RacingGameResult racingGameResult, Winner winner,
                                OutputView outputView) {
        this.racingGame = racingGame;
        this.racingGameResult = racingGameResult;
        this.winner = winner;
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
        winner.inform(getFinalGameResult(racingCars, leftNumberOfAttempts));
    }

    private String getFinalGameResult(List<RacingCar> racingCars, NumberOfAttempts leftNumberOfAttempts) {
        String gameResult;
        do {
            gameResult = renewRecentGameResult(racingCars, leftNumberOfAttempts);
        } while (leftNumberOfAttempts.existsLeftNumberOfAttempts());
        return gameResult;
    }

    private String renewRecentGameResult(List<RacingCar> racingCars, NumberOfAttempts leftNumberOfAttempts) {
        racingGame.startSingleGame(racingCars);
        String gameResult = racingGameResult.create(racingCars);
        outputView.printSingleGameResult(gameResult);
        leftNumberOfAttempts.attempt();
        return gameResult;
    }
}
