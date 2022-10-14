package racing.domain;

import java.util.ArrayList;
import java.util.List;

import static racing.util.Random.createRandomValue;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(int carCount) {
        this.cars = createCars(carCount);
    }

    private List<Car> createCars(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }
        return carList;
    }

    public void moveEvent() {
        for (Car car : cars) {
            car.move(createRandomValue());
        }
    }

    public List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();
        for (Car car : cars) {
            distances.add(car.getDistance());
        }
        return distances;
    }
}
