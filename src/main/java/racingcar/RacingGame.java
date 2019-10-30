package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCycle> cycles = new ArrayList<>();

    private static final int FIRST_INDEX = 0;

    public RacingGame(List<String> carNames, int runCount) {
        run(carNames, runCount);
    }

    private void run(List<String> carNames, int runCount) {
        for (int i = 0; i < runCount; i++) {
            RacingCycle cycle = getRacingCycle(i, carNames);
            cycle.doCycle();
            cycles.add(cycle);
        }
    }

    private RacingCycle getRacingCycle(int i, List<String> carNames) {
        if (i == FIRST_INDEX) {
            return new RacingCycle(readyCars(carNames));
        }

        List<Car> cars = cycles.get(i - 1).getCycle();
        return new RacingCycle(cars);
    }

    private List<Car> readyCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }
        return cars;
    }

    public List<RacingCycle> getCycles() {
        return cycles;
    }
}
