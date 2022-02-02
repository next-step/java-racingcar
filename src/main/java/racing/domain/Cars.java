package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.domain.car.Car;
import racing.domain.car.CarHistory;
import racing.domain.car.Position;

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
            carHistories.add(new CarHistory(car.getName(), new Position(car.getPositionValue())));
        }
        return carHistories;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    public final int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPositionValue());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
