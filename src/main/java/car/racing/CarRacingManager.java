package car.racing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRacingManager {

    private static final int LIMIT = 10;
    private static final String FORWARD = "-";

    private final CarForwardable forwardable;
    private final Random random = new Random();
    final List<Car> cars = new ArrayList<>();

    public CarRacingManager(CarForwardable forwardable) {
        this.forwardable = forwardable;
    }

    public void setupCars(String[] names) {
        this.cars.clear();
        IntStream.range(0, names.length)
                .forEach(i -> cars.add(new Car(names[i])));
    }

    public List<Car> forwardEachCar() {
        cars.stream()
                .filter(car -> forwardable.forwardable(random.nextInt(LIMIT)))
                .forEach(car -> car.forward(FORWARD));
        return cars;
    }

    public List<String> racingWinners() {
        List<Car> carsInFastOrder = cars.stream()
                .sorted(Comparator.comparing(Car::getForwardCount).reversed())
                .collect(Collectors.toList());

        Car carMostFast = carsInFastOrder.get(0);
        return carsInFastOrder.stream()
                .filter(car -> car.getForwardCount() == carMostFast.getForwardCount())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}