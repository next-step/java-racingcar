package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.GameResultInfo;
import racingcar.domain.NumberOfAttempts;
import racingcar.domain.PositiveNumber;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.view.OutputView;
import racingcar.view.RacingGameResult;
import racingcar.view.Winner;

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
        outputView.printWinners(getWinners(racingCars, leftNumberOfAttempts));
    }

    private String getWinners(List<RacingCar> racingCars, NumberOfAttempts leftNumberOfAttempts) {
        return winner.inform(getFinalGameResult(racingCars, leftNumberOfAttempts));
    }

    private String getFinalGameResult(List<RacingCar> racingCars, NumberOfAttempts leftNumberOfAttempts) {
        String gameResult;
        do {
            GameResultInfo gameResultInfo = getGameResultInfo(racingCars, leftNumberOfAttempts);
            leftNumberOfAttempts = renewLeftNumberOfAttempts(gameResultInfo);
            gameResult = renewGameResult(gameResultInfo);
        } while (leftNumberOfAttempts.existsLeftNumberOfAttempts());
        return gameResult;
    }

    private GameResultInfo getGameResultInfo(List<RacingCar> racingCars, NumberOfAttempts leftNumberOfAttempts) {
        racingGame.startSingleGame(racingCars);
        String gameResult = racingGameResult.create(racingCars);
        outputView.printSingleGameResult(gameResult);
        return new GameResultInfo(leftNumberOfAttempts.attempt(), gameResult);
    }

    private NumberOfAttempts renewLeftNumberOfAttempts(GameResultInfo gameResultInfo) {
        return gameResultInfo.getLeftNumberOfAttempts();
    }

    private String renewGameResult(GameResultInfo gameResultInfo) {
        return gameResultInfo.getGameResult();
    }
}
