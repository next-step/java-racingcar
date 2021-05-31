package racing.domain;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public int findMaxMoveCountCar() {
        return cars.stream().mapToInt(Car::getMoveCount)
                .max().orElseThrow(NoSuchElementException::new);
    }

    public List<String> findCorrespondMoveCountCarNames(int moveCount){
        return cars.stream().filter(car -> car.getMoveCount() == moveCount).map(Car::getName)
                .collect(Collectors.toList());
    }
}
