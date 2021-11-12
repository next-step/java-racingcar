package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

public class RacingGame {
    private final int racingCount;
    private final MyRacing racing;

    public RacingGame(int carCount, int racingCount) {
        this.racing = new MyRacing(carCount);
        this.racingCount = racingCount;
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            racing.race();
            ResultView.draw(racing);
        }
    }
}
