package racingcar.car;

import java.util.List;

public class NextStepCars {
    private final List<Car> nextStepCars;

    public NextStepCars(List<Car> nextStepCars) {
        this.nextStepCars = nextStepCars;
    }

    public List<Car> getNextStepCars() {
        return nextStepCars;
    }
}
