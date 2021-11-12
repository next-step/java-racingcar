package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

public class RacingGame {
    private final int racingCount;
    private final Circuit circuit;

    public RacingGame(int carCount, int racingCount) {
        this.circuit = new Circuit(carCount);
        this.racingCount = racingCount;
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            circuit.race();
            ResultView.draw(circuit);
        }
    }
}
