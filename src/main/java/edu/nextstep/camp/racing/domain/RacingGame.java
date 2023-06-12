package edu.nextstep.camp.racing.domain;

import edu.nextstep.camp.racing.view.RacingOutputView;

public class RacingGame {

    private final RacingInfo racingInfo;
    private final Cars cars;
    public RacingGame(RacingInfo racingInfo) {
        this.racingInfo = racingInfo;
        cars = new Cars(racingInfo.getCarNames());
    }

    public void startGame() {
        int movingCount = racingInfo.getMovingCount();

        for (int i = 0; i < movingCount; i++) {
            cars.moveCars();
        }

        RacingOutputView.printWinners(cars.winners());
    }
}
