package racingcar.domain;

import racingcar.util.ResultView;

public class RacingMachine {
    private static final int ROUND_END = 0;

    private static Cars cars;

    private RacingMachine() {
    }

    public static void runMachine(String[] carNames, int numberOfRounds) {
        cars = new Cars(carNames);
        ResultView.startGame();
        while (numberOfRounds-- > ROUND_END) {
            cars.move();
            cars.showResult();
        }
        ResultView.showWinners(cars.getWinnerNames());
    }
}
