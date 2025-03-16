package game;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public static final int BOUND = 10;
    private List<Car> cars;

    private Cars() {}

    public Cars(int count) {
        this.cars = createCars(count);
    }

    private List<Car> createCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            cars.add(new Car());
        }
        return cars;
    }

    public void race() {
        for (Car car : this.cars) {
            car.move(RandomUtils.nextInt(BOUND));
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : this.cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }
}
