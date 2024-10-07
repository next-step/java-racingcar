package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingGame;
import racingcar.service.dto.GameResult;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final ResultView resultView;

    public RacingController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void play() {
        String carNames = inputView.getRacingCars();
        int matchCount = inputView.getMatchCount();
        RacingGame game = RacingGame.getInstance();
        List<RacingCar> racingCars = game.createRacingCars(carNames);

        List<GameResult> results = game.race(matchCount, racingCars);

        resultView.printGameResult(results);
        resultView.printWinners(game.findWinners(racingCars));
    }
}
