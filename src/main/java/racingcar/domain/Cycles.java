package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cycles {

    static final int FIRST_INDEX = 0;
    private static final int LAST_INDEX = -1;

    private List<RacingCycle> cycles;
    private List<String> carNames;
    private int winnerLocation;

    public Cycles(List<String> carNames) {
        this.carNames = carNames;
        this.cycles = new ArrayList<>();
    }

    public void run(int runCount) {
        for (int i = 0; i < runCount; i++) {
            runRacingCycle();
        }
        this.winnerLocation = getLastCycle().findMaxLocation();
    }

    private void runRacingCycle() {

        if (cycles.size() == FIRST_INDEX) {
            cycles.add(new RacingCycle(carNames));
            return;
        }

        cycles.add(new RacingCycle(getLastCycle()));
    }

    public List<String> findWinners() {
        return getLastCycle().getCycle().stream()
                .filter(c -> c.equalsLocation(winnerLocation))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<RacingCycle> getCycles() {
        return Collections.unmodifiableList(cycles);
    }

    public RacingCycle getLastCycle() {
        return cycles.get(cycles.size() + LAST_INDEX);
    }

}
