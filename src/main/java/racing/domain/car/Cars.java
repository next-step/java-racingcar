package racing.domain.car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private static final int RANGE_OF_RANDOM_NUMBER = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        checkZeroCar(this.cars);
        checkSameNameCars(this.cars);
    }

    public Cars(List<String> names, int initValue) {
        this(
            names.stream()
                .map(name -> new Car(name, initValue))
                .collect(Collectors.toList())
        );
    }

    private void checkSameNameCars(List<Car> cars) {
        if (cars.stream().count()
            != cars.stream().map(Car::getName).distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름은 들어갈 수 없습니다.");
        }
    }

    private void checkZeroCar(List<Car> cars) {
        if (Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 자동차 개수는 적어도 1개 이상이어야 합니다.");
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
