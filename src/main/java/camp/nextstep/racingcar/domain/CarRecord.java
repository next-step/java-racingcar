package camp.nextstep.racingcar.domain;

import java.util.UUID;

public class CarRecord {

    private final UUID carId;
    private final int distance;

    public CarRecord(UUID carId, int distance) {
        this.carId  = carId;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

}
