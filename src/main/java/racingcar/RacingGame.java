package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCycle> cycles = new ArrayList<>();

    public RacingGame(int carNumber, int runNumber) {
        run(carNumber, runNumber);
    }

    private void run(int carNumber, int runNumber) {

        for (int i = 0; i < runNumber; i++) {
            RacingCycle cycle = getRacingCycle(i, carNumber);
            cycle.doCycle();
            cycles.add(cycle);
        }

    }

    private RacingCycle getRacingCycle(int i, int carNumber) {
        if (i == 0) {
            return new RacingCycle(carNumber);
        }

        return new RacingCycle(cycles.get(i - 1).get());
    }

    public List<RacingCycle> getCycles() {
        return cycles;
    }
}
