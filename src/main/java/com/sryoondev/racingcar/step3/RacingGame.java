package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.ResultView;

public class RacingGame {
    private final int racingCount;
    private final Circuit circuit;
    private final ResultView resultView;

    public RacingGame(int carCount, int racingCount, ResultView resultView) {
        this.circuit = new Circuit(carCount, resultView);
        this.racingCount = racingCount;
        this.resultView = resultView;
    }

    public void start() {
        for (int i = 0; i < racingCount; i++) {
            circuit.race();
            resultView.capture(circuit);
        }
    }
}
