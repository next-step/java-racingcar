package carracing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackHistory {
    private final List<Cars> carsHistory = new ArrayList<>();

    public void add(Cars cars) {
        carsHistory.add(cars.copyOf());
    }

    public List<Cars> getCarsHistory() {
        return Collections.unmodifiableList(carsHistory);
    }
}
