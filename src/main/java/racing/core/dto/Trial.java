package racing.core.dto;

import racing.core.domain.Cars;

import java.util.Objects;

public class Trial {

    private final Cars stateOfCarsAtThatTrial;

    public Trial(Cars stateOfCarsAtThatTrial) {
        this.stateOfCarsAtThatTrial = stateOfCarsAtThatTrial;
    }

    public Cars getStateOfCarsAtThatTrial() {
        return stateOfCarsAtThatTrial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trial trial = (Trial) o;
        return stateOfCarsAtThatTrial.equals(trial.stateOfCarsAtThatTrial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stateOfCarsAtThatTrial);
    }
}
