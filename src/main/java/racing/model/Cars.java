package racing.model;

import java.util.ArrayList;
import java.util.List;
import racing.service.NumberGenerator;

public class Cars {
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Cars create(int count, NumberGenerator numberGenerator) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Car car = new Car();
            carList.add(car);
        }
        return new Cars(carList, numberGenerator);
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(numberGenerator.generateNumber());
        }
    }

    public List<Integer> getPositions() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return positions;
    }

    public int size() {
        return cars.size();
    }

}
