package car.racing;


import car.racing.domain.CarRacingGame;
import car.racing.view.ResultViewContract;

import java.util.stream.IntStream;

public class CarRacingViewController {

    private final ResultViewContract resultView;
    private final CarRacingGame racingGame;

    public CarRacingViewController(ResultViewContract resultView, CarRacingGame racingGame) {
        this.resultView = resultView;
        this.racingGame = racingGame;
    }

    public void input(int tryCount) {
        resultView.resultTitle();
        forwardCars(tryCount);
        showRacingWinners();
    }

    private void forwardCars(int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    racingGame.forwardCarEachTry();
                    showRacingResultEachTry();
                });
    }

    private void showRacingResultEachTry() {
        racingGame.getCars().forEach(resultView::forward);
        resultView.newLine();
    }

    private void showRacingWinners() {
        resultView.winners(racingGame.findWinners());
    }
}