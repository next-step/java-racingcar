package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cycles {

    private static final int FIRST_INDEX = 0;

    private List<RacingCycle> cycles;

    public Cycles() {
        this.cycles = new ArrayList<>();
    }

    public void doCycle(List<String> carNames) {
        if (cycles.size() == FIRST_INDEX) {
            cycles.add(new RacingCycle(readyCars(carNames)));
            return;
        }

        List<Car> cars = cycles.get(cycles.size() - 1).getCycle();
        cycles.add(new RacingCycle(cars));
    }

    private List<Car> readyCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }
        return cars;
    }

    public List<RacingCycle> getCycles() {
        return Collections.unmodifiableList(cycles);
    }
}
