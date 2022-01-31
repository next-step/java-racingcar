package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racing.domain.car.Car;
import racing.domain.car.CarHistory;

public class Cars {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public List<CarHistory> driveCars() {
        final List<CarHistory> carHistories = new ArrayList<>();
        for (Car car : cars) {
            car.drive(generateRandomNumber());
            carHistories.add(new CarHistory(car.getName(), car.getPosition()));
        }
        return carHistories;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    public final int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition().getValue());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
