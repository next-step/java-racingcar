package racing;

import racing.domain.Cars;
import racing.domain.RacingGameInfo;
import racing.view.ResultView;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private static final ResultView resultView = new ResultView();
    private Integer tryCount;

    RacingGame(RacingGameInfo racingGameInfo) {
        cars = new Cars(racingGameInfo.carCount);
        this.tryCount = racingGameInfo.tryCount;
    }

    public void tryEvent() {
        for (int i = 0; i < tryCount; i++) {
            System.out.println("");
            play(cars);
        }
    }

    private void play(Cars cars) {
        cars.moveEvent();

        List<Integer> distances = cars.getDistances();
        resultView.result(distances);
    }
}
