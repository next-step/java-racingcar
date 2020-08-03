package camp.nextstep.edu.rebellion.racing;

import java.util.Collections;
import java.util.List;

public class SnapShotEntry {
    private final List<RacingCar> cars;

    public SnapShotEntry(List<RacingCar> cars) {
        this.cars = cars;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getWinners() {
        return "";
    }
}
