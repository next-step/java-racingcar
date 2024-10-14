package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RacingCarStates {
    private final List<RacingCarState> carStates;

    private RacingCarStates(List<RacingCarState> carStates) {
        this.carStates = carStates;
    }

    public static RacingCarStates valueOf(RacingFleet fleet) {
        List<RacingCar> racingCars = fleet.getRacingCars();
        List<RacingCarState> carStates = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            carStates.add(RacingCarState.valueOf(racingCar));
        }
        return new RacingCarStates(carStates);
    }

    public List<RacingCarState> value() {
        return this.carStates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarStates that = (RacingCarStates) o;
        return Objects.equals(value(), that.value());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value());
    }
}
