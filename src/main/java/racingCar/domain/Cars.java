package racingCar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private List<Car> cars;

    public Cars(String carNames) {
        this.cars = makeCars(splitCarNames(carNames));
    }

    private List<CarName> splitCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER)).map(carName -> new CarName(carName)).collect(Collectors.toList());
    }

    public Cars(List<Car> carList) {
        this.cars = carList;
    }

    private List<Car> makeCars(List<CarName> carNames) {
        List<Car> preparedCar = new ArrayList<>();
        for (CarName carName : carNames) {
            Car newCar = new Car(carName);
            preparedCar.add(newCar);
        }
        return preparedCar;
    }

    public int size() {
        return this.cars.size();
    }

    public List<Car> allCar() {
        return this.cars;
    }

    public List<Car> fastestCars() {
        Distance maxDistance = findMaxDistance();
        return this.cars.stream().filter(car -> car.distance().equals(maxDistance)).collect(Collectors.toList());
    }

    private Distance findMaxDistance() {
        Distance maxDistance = new Distance();
        for (Car car : this.cars) {
            maxDistance = maxDistance.max(car.distance());
        }
        return maxDistance;
    }
}
