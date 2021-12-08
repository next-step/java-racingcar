package carracing.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class CarsGroup {
    private final List<Cars> carsGroup;

    public CarsGroup(List<Cars> carsGroup) {
        this.carsGroup = carsGroup;
    }

    public List<Cars> getCarsGroup() {
        return Collections.unmodifiableList(carsGroup);
    }

    public Cars lastCars() {
        return carsGroup.stream()
                .reduce((first, second) -> second)
                .orElseThrow(() -> new NoSuchElementException("last Cars is not found."));
    }
}
