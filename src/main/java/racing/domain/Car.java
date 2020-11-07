package racing.domain;

import static racing.domain.CarConfig.*;

public class Car {

    private final CarThrottleSensor sensor = new CarThrottleSensor();
    private final String name;

    private final ElectronicControlUnit ecu;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.ecu = new ElectronicControlUnit();
        this.distance = 0;
    }

    public void move() {
        distance++;
        if(sensor.check()) {
            ecu.speedRecord(ECU_NORMAL_MOVE_CODE);
            return;
        }
        ecu.speedRecord(ECU_STOP_MOVE_CODE);
    }

    public ElectronicControlUnit getEcu() {
        return ecu;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

}
