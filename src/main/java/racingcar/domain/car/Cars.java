package racingcar.domain.car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static racingcar.utils.RandomInt.returnRandom;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxPosition() {
        return cars.stream( )
                .max(Comparator.comparing(Car::getPosition))
                .map(Car::getPosition)
                .orElseThrow(IllegalArgumentException::new);
    }
//    public void moveCars2() {
//        for (Car car : cars) {
//            car.move2(returnRandom());
//        }
//    }

    public String findWinnerNames() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.equalToMaxPosition(maxPosition))
                .flatMap(car -> Stream.of(car.getCarName()))
                .collect(Collectors.joining(","));
    }


}
