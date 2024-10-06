package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.RacingGame;

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


        while (game.isMatching(matchCount)) {
            int currentCount = game.match(matchCount, racingCars);
            resultView.printRacingCarsStatus(game.getRacingCarsPosition(racingCars));
            matchCount = currentCount;
        }

        resultView.printWinners(game.findWinners(racingCars));
    }
}
