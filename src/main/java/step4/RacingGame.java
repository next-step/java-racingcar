package step4;

import step4.car.Cars;
import step4.view.result.ResultView;

public class RacingGame {

    private static final int GAME_COUNT_LOWER_BOUND = 0;
    private final Cars cars;

    private int remainGameCount;

    public RacingGame(String[] carNames, int remainGameCount) {
        this.cars = new Cars(carNames);
        this.remainGameCount = remainGameCount;
        printTitle();
    }

    public void race(int gameCount) {
        for (int i = 1; i <= gameCount; i++) {
            validateLimit();
            remainGameCount--;
            cars.tryMove();
            printProgressOfRace();
        }
    }

    private void printProgressOfRace() {
        ResultView resultView = new ResultView();
        resultView.printProgressOfRace(cars);

        if (isLastRace())
            resultView.printWinnerOfRacing(cars);
    }

    private boolean isLastRace() {
        return remainGameCount == GAME_COUNT_LOWER_BOUND;
    }

    private void printTitle() {
        System.out.println("실행 결과");
    }

    private void validateLimit() {
        if (remainGameCount <= GAME_COUNT_LOWER_BOUND)
            throw new IllegalStateException("remainGameCount is zero");
    }
}
