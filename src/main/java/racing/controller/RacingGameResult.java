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
        this.winnerList = getWinnerCars(getMaxPosition());
    }

    public int getMaxPosition() {
        return RacingGame.findMaxPosition(racingCars);
    }

    public List<String> getWinnerCars(int maxCarPosition) {
        return RacingGame.findWinnersCars(racingCars, maxCarPosition);
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
