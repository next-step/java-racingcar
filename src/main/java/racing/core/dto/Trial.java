package racing.core.dto;

import racing.core.domain.Cars;

import java.util.Objects;

public class Trial {

    private final Cars cars;

    public Trial(Cars stateOfCarsAtThatTrial) {
        this.cars = stateOfCarsAtThatTrial;
    }

    public Cars getCarsAtThatTrial() {
        return cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return cars.equals(trial.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
