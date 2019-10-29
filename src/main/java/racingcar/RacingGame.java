package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<RacingCycle> cycles = new ArrayList<>();

    private static final int FIRST_INDEX = 0;

    public RacingGame(List<String> carNameList, int runNumber) {
        run(carNameList, runNumber);
    }

    private void run(List<String> carNameList, int runNumber) {

        for (int i = 0; i < runNumber; i++) {
            RacingCycle cycle = getRacingCycle(i, carNameList);
            cycle.doCycle();
            cycles.add(cycle);
        }

    }

    private RacingCycle getRacingCycle(int i, List<String> carNameList) {
        if (i == FIRST_INDEX) {
            return new RacingCycle(readyCars(carNameList));
        }

        List<Car> cars = cycles.get(i - 1).get();
        return new RacingCycle(cars);
    }

    private List<Car> readyCars(List<String> carNameList) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNameList) {
            cars.add(new Car(s));
        }
        return cars;
    }

    public List<RacingCycle> getCycles() {
        return cycles;
    }
}
