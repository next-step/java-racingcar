package racing.carRacing;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    public static final int ZERO = 0;

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars initCars(CarNames carNames) {
        List<Car> cars = IntStream.range(ZERO, carNames.numberOfCars())
                .mapToObj(carNames::matchCarName)
                .collect(Collectors.toList());

        return new Cars(cars);
    }

    public void run() {
        cars.forEach(car -> car.run(new RandomMovementStrategy()));
    }

    public Car getCurrentCar(int index) {
        return cars.get(index);
    }

    public int getCarsSize() {
        return cars.size();
    }

}
