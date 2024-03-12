package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class NeverMoveCars extends Cars{

    private final List<Car> cars;

    public NeverMoveCars(CarsNames carsNames) {
        super(carsNames);
        this.cars = initialCars(carsNames);
    }

    private static List<Car> initialCars(CarsNames carsNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.size(); i++) {
            cars.add(new Car(carsNames.getName(i)));
        }
        return cars;
    }

    @Override
    public void raceStart(RaceCount raceCount, RaceRecorder recorder) {
        for (int i = 0; i < raceCount.value(); i++) {
            runCars();
            recorder.record(cars);
        }
    }

    private void runCars() {
        for (Car car : cars) {
            car.run(new NeverMoveCondition());
        }
    }
}
