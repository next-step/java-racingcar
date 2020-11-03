package study.step3;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CarRacing {

    private final Set<Car> cars;
    private final int steps;
    private final RaceRecord raceRecord = new RaceRecord();

    public CarRacing(Circuit circuit) {
        cars = circuit.getCars();
        steps = circuit.getLaps();
    }

    public void start() {
        for (int i = 0; i < steps; i++) {
            move();
            recording();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void recording() {
        for (Car car : cars) {
            raceRecord.saveRecord(car);
        }
    }

    public boolean hasRecord() {
        return raceRecord.getTotalTry() > 0;
    }

    public Set<String> getWinners() {
        return raceRecord.listMostMovingNames();
    }


    public Map<String, List<Boolean>> getRecords() {
        return Collections.emptyMap();
    }
}
