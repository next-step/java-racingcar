package racing.domain;

import java.util.ArrayList;
import java.util.List;

import static racing.util.Random.createRandomValue;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String[] carNames) {
        this.cars = createCars(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
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
