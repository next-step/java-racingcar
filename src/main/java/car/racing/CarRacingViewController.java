package car.racing;



import car.racing.domain.CarRacingGame;
import car.racing.domain.CarRacingWinners;
import car.racing.view.ResultViewContract;

import java.util.stream.IntStream;

public class CarRacingViewController {

    private final ResultViewContract resultView;
    private final CarRacingGame racingGame;
    private final CarRacingWinners racingWinners;

    public CarRacingViewController(ResultViewContract resultView, CarRacingGame racingGame, CarRacingWinners racingWinners) {
        this.resultView = resultView;
        this.racingGame = racingGame;
        this.racingWinners = racingWinners;
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
        resultView.winners(racingWinners.racingWinners());
    }
}