package racinggame.domain;

import racinggame.view.CarsCount;
import racinggame.view.RaceCount;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(CarsCount carCount) {
        this.cars = initialCars(carCount);
    }

    private List<Car> initialCars(CarsCount carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount.value(); i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void raceStart(RaceCount raceCount, RaceRecorder recorder) {
        for (int i = 0; i < raceCount.value(); i++) {
            runCars();
            recorder.record(getCarsPositions());
        }
    }

    private void runCars() {
        for (Car car : cars) {
            car.run(new MoveCondition());
        }
    }

    public List<Position> getCarsPositions() {
        List<Position> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.position());
        }
        return positions;
    }
}
