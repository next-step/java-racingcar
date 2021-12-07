package carracing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CarsGroup {
    private final List<Cars> carsGroup;

    public CarsGroup(Cars cars, int numberOfTrials, MovementPolicy movementPolicy) {
        this.carsGroup = new ArrayList<>(numberOfTrials);
        initiateCarsGroup(cars, numberOfTrials, movementPolicy);
    }

    public List<Cars> getCarsGroup() {
        return Collections.unmodifiableList(carsGroup);
    }

    public Cars lastCars() {
        return carsGroup.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("last Cars is not found."));
    }

    private void initiateCarsGroup(Cars cars, int numberOfTrials, MovementPolicy movementPolicy) {
        carsGroup.add(cars);
        for (int i = 0; i < numberOfTrials - 1; i++) {
            cars = cars.moveCars(movementPolicy);
            carsGroup.add(cars);
        }
    }
}
