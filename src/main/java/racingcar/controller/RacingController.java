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
        int carNumber = inputView.getCarNumber();
        int matchCount = inputView.getMatchCount();
        List<RacingCar> racingCars = RacingGame.getInstance().createRacingCars(carNumber);


        while (RacingGame.getInstance().isMatching(matchCount)) {
            int currentCount = RacingGame.getInstance().match(matchCount, racingCars);
            resultView.printRacingCarsStatus(RacingGame.getInstance().getRacingCarsPosition(racingCars));
            matchCount = currentCount;
        }
    }
}
