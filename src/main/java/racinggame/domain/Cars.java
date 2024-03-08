package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final int raceCount;

    public Cars(int carCount, int raceCount) {
        this.cars = initialCars(carCount);
        this.raceCount = raceCount;
    }

    private static List<Car> initialCars(int carCount) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void raceStart() {
        for (int i = 0; i < raceCount; i++) {
            runCars();
        }
    }

    private void runCars() {
        for (int j = 0; j < cars.size(); j++) {
            cars.get(j).run(new MoveCondition());
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
