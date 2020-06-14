package racing.controller;

import racing.domain.car.RacingCars;
import racing.domain.game.RacingGame;
import racing.view.ResultView;

import java.util.List;

public class RacingGameResult {
    private RacingCars racingCars;
    private List<String> winnerList;

    public RacingGameResult(RacingCars racingCars, List<String> winners) {
        this.racingCars = racingCars;
        this.winnerList = resultWinnerCars(resultMaxPosition());
    }

    private int resultMaxPosition() {
        RacingGame racingGame = new RacingGame(racingCars);
        return racingGame.findMaxPosition();
    }

    public List<String> resultWinnerCars(int maxCarPosition) {
        return RacingGame.findWinnerCars(racingCars, maxCarPosition);
    }

    public void resultRacing(int times) {
        RacingGame racingGame = new RacingGame(racingCars);
        List<RacingCars> racingCarsList = racingGame.race(times);

        for (RacingCars cars : racingCarsList) {
            ResultView.printResult(cars.getCars());
        }
    }

    public List<String> getWinnerList() {
        return winnerList;
    }
}
