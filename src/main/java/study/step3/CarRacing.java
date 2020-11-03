package study.step3;

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
            saveRecord();
        }
    }

    private void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void saveRecord() {
        for (Car car : cars) {
            raceRecord.saveRecord(car);
        }
    }

    public Set<String> getWinners() {
        return raceRecord.listMostMovingNames();
    }

    public RaceRecord getRecords() {
        return raceRecord;
    }
}
