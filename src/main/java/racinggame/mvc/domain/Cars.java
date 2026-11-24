package racinggame.mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public final class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public Cars(String carNames) {
        this(parseCars(carNames));
    }

    private static List<Car> parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",", -1)) {
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
        List<Car> farthestCars = new ArrayList<>();
        int farthestPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position > farthestPosition) {
                farthestPosition = position;
                farthestCars.clear();
            }
            if (position == farthestPosition) {
                farthestCars.add(car);
            }
        }
        return List.copyOf(farthestCars);
    }
}
