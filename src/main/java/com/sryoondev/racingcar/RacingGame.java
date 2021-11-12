package com.sryoondev.racingcar;

public class RacingGame {
    private final int racingCount;
    private MyRacing racing;

    public RacingGame(int carCount, int racingCount) {
        this.racing = new MyRacing(carCount);
        this.racingCount = racingCount;
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            racing.race();
        }
    }
}
