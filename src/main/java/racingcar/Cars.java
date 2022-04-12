package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private final List<Car> carList;

    private Cars(List<Car> cars) {
        this.carList = cars;
    }

    public void move(List<Integer> moveCounts) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            car.move(moveCounts.get(i));
        }
    }

    public List<Integer> getCurrentLocations() {
        return carList.stream()
                .map(Car::getCurrentLocation)
                .collect(Collectors.toList());
    }

    public static Cars generateCars(int carCount) {
        return new Cars(IntStream.range(0, carCount)
                .mapToObj(n -> new Car())
                .collect(Collectors.toList()));
    }
}
