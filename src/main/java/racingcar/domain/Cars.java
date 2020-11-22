package racingcar.domain;

import racingcar.util.RandomNumberUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carName){
        this.cars = makeCars(carName);
    }

    private List<Car> makeCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::newCar)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsByName(List<String> carNames) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (carNames.contains(car.getName())) {
                result.add(car);
            }
        }
        return result;
    }

    public void tryToMove() {
        getCars().forEach(c -> c.tryToMove(RandomNumberUtil.getRandomNumber()));
    }
}
