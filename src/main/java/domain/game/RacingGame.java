package domain.game;

import domain.car.Cars;
import domain.record.Records;

public class RacingGame {

    private final Cars cars;
    private final Records records;

    public RacingGame(String... nameOfCars) {
        this.cars = Cars.make(nameOfCars);
        this.records = new Records(nameOfCars);
    }

    public Records start(int trial) {
        for (int i = 0; i < trial; i++) {
            cars.move();
            records.add(cars);
        }

        return records;
    }
}
