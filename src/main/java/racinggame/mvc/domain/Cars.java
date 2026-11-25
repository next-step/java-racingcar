package racinggame.mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public final class Cars {

    private static final String NAME_DELIMITER = ",";
    private static final int KEEP_EMPTY_NAMES = -1;

    private final List<Car> cars;

    public Cars(String carNames) {
        this(parseCars(carNames));
    }

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    private static List<Car> parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(NAME_DELIMITER, KEEP_EMPTY_NAMES)) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move(IntSupplier numberSupplier) {
        for (Car car : cars) {
            car.move(numberSupplier.getAsInt());
        }
    }

    public List<Car> farthestCars() {
        if (cars.isEmpty()) {
            return List.of();
        }

        Car farthestCar = findFarthestCar();
        return cars.stream()
            .filter(farthestCar::hasSamePositionAs)
            .toList();
    }

    private Car findFarthestCar() {
        Car farthestCar = cars.getFirst();
        for (Car car : cars) {
            farthestCar = car.isFartherThan(farthestCar) ? car : farthestCar;
        }
        return farthestCar;
    }
}
