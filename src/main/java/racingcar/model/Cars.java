package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Cars {

    private static final int RANGE_START_NUM = 0;

    private final List<Car> carList;

    public Cars(List<Car> cars) {
        this.carList = cars;
    }

    public static Cars of(int carCount, Motor motor) {
        List<Car> cars = IntStream.range(RANGE_START_NUM, carCount)
                .mapToObj(v -> new Car(motor))
                .collect(toList());

        return new Cars(cars);
    }

    public void run() {
        for (Car car : carList) {
            car.run();
        }
    }

    public int sizeOfCar() {
        return carList.size();
    }

    public List<Integer> getPositions() {
        return carList.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }
}
