package racing.domain.game;

import racing.domain.car.CarForwardBehavior;
import racing.domain.car.RacingCars;
import racing.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public void race(int times) {
        for (int i = 0; i < times; i++) {
            racingCars.moveCars(new CarForwardBehavior());
            ResultView.printResult(racingCars.getCars());
        }
    }

    public List<String> getWinnersCarName() {
        List<String> winnerList = new ArrayList<>();
        RacingGameResult racingGameResult = new RacingGameResult(racingCars, winnerList);
        return racingGameResult.getWinnerList();
    }
}
