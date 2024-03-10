package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(int carCount) {
        this.cars = initialCars(carCount);
    }

    private List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void raceStart(int raceCount, RaceRecorder recorder) {
        for (int i = 0; i < raceCount; i++) {
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
