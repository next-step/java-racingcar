package racingcar.domain;

import java.util.List;

public class RacingGame {

    private Cycles cycles;

    public RacingGame(List<String> carNames, int runCount) {
        cycles = new Cycles();
        run(carNames, runCount);
    }

    private void run(List<String> carNames, int runCount) {
        for (int i = 0; i < runCount; i++) {
            cycles.doCycle(carNames);
        }
    }

    public Cycles getCycles() {
        return cycles;
    }
}
