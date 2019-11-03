package racingcar.domain;

import java.util.List;

public class RacingGame {

    private Cycles cycles;

    public RacingGame(List<String> carNames, int runCount) {
        cycles = new Cycles(carNames);
        run(runCount);
    }

    private void run(int runCount) {
        cycles.run(runCount);
    }

    public Cycles getCycles() {
        return cycles;
    }

}
