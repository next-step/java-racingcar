package car.racing;


import java.util.stream.IntStream;

public class CarRacingViewController {

    private final ResultViewContract resultView;
    private final CarRacingManager carRacingManager;

    public CarRacingViewController(ResultViewContract resultView, CarRacingManager carRacingManager) {
        this.resultView = resultView;
        this.carRacingManager = carRacingManager;
    }

    public void input(int tryCount) {
        resultView.resultTitle();
        forwardCars(tryCount);
        showRacingWinners();
    }

    private void forwardCars(int tryCount) {
        IntStream.range(0, tryCount)
                .forEach(i -> {
                    carRacingManager.forwardCarEachTry();
                    showRacingResultEachTry();
                });
    }

    private void showRacingResultEachTry() {
        carRacingManager.getCars().forEach(resultView::forward);
        resultView.newLine();
    }

    private void showRacingWinners() {
        resultView.winners(carRacingManager.racingWinners());
    }
}