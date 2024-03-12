package racingcar.domain.dto;

import racingcar.domain.DrivingDistance;
import racingcar.domain.Name;

public class DriveResult {

    private final Name name;
    private final DrivingDistance drivingDistance;

    public DriveResult(Name name, DrivingDistance drivingDistance) {
        this.name = name;
        this.drivingDistance = drivingDistance;
    }

    public String name() {
        return name.value();
    }

    public int drivingDistance() {
        return drivingDistance.value();
    }
}
