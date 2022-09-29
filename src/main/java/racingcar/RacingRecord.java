package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingRecord {
    private static final List<RoundCars> records = new ArrayList<>();

    public List<RoundCars> retrieveRecord() {
        return records;
    }

    public void addCarsPosition(RoundCars roundCars) {
        List<Car> recordCars = new ArrayList<>();
        List<Car> cars = roundCars.retrieveCars();

        for (Car car : cars) {
            recordCars.add(new Car(car.getPosition()));
        }

        RoundCars recordRoundCar = new RoundCars(recordCars);
        records.add(recordRoundCar);
    }
}
