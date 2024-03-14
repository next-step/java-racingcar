package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(CarsNames carsNames) {
        this(initialCars(carsNames));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<Car> initialCars(CarsNames carsNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carsNames.size(); i++) {
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

    public void runCars() {
        for (Car car : cars) {
            car.run(new MoveCondition());
        }
    }
}
