package racing.model;

import java.util.ArrayList;
import java.util.List;
import racing.service.NumberGenerator;

public class Cars {
    private static final int RAND = 10;
    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move(numberGenerator.generateRandomNumber(RAND));
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
