package racingcar.controller;

import static racingcar.constant.Constant.ZERO;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;
import racingcar.view.OutputView;

public class RacingGameController {

    private final RacingGame racingGame;
    private final RacingGameResult racingGameResult;
    private final OutputView outputView;

    public RacingGameController(RacingGame racingGame, RacingGameResult racingGameResult, OutputView outputView) {
        this.racingGame = racingGame;
        this.racingGameResult = racingGameResult;
        this.outputView = outputView;
    }

    public void run(int numberOfCars, int numberOfAttempts) {
        List<RacingCar> racingCars = createRacingCars(numberOfCars);
        startAllGames(numberOfAttempts, racingCars);
    }

    private List<RacingCar> createRacingCars(int numberOfCars) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            racingCars.add(new RacingCar());
        }
        return racingCars;
    }

    private void startAllGames(int numberOfAttempts, List<RacingCar> racingCars) {
        outputView.printGameResultMent();
        while (numberOfAttempts-- > ZERO) {
            racingGame.startSingleGame(racingCars);
            outputView.printSingleGameResult(racingGameResult.create(racingCars));
        }
    }
}
