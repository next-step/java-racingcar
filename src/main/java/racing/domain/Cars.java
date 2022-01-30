package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private List<Car> cars;

    public Cars(List<String> names) {
        checkCarCount(names);
        cars = new ArrayList<>();
        for(String name: names) {
            cars.add(new Car(name));
        }
    }

    private void checkCarCount(List<String> names) {
        if (Objects.isNull(names)) {
            throw new IllegalArgumentException("[ERROR] 최소 1대 이상의 자동차가 필요합니다.");
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
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

}
