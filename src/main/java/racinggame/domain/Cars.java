package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(CarsNames carsNames) {
        this.cars = initialCars(carsNames);
    }

    private List<Car> initialCars(CarsNames carsNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.length(); i++) {
            cars.add(new Car(carsNames.getName(i)));
        }
        return cars;
    }

    public void raceStart(RaceCount raceCount, RaceRecorder recorder) {
        for (int i = 0; i < raceCount.value(); i++) {
            runCars();
            recorder.record(cars);
        }
    }

    private void runCars() {
        for (Car car : cars) {
            car.run(new MoveCondition());
        }
    }
}
