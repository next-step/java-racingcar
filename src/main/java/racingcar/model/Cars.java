package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Result moveOnce() {
        List<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            car.move();
            result.add(car.getPosition());
        }
        return new Result(result);
    }

    public List<Car> findWinner() {
        return cars.stream()
                .filter(it -> it.isWinner(findHighestPositionValue()) == true)
                .collect(Collectors.toList());
    }

    public int findHighestPositionValue() {
        return cars.stream()
                .map(it -> it.getPosition())
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public List<Car> getCars() {
        return cars;
    }
}