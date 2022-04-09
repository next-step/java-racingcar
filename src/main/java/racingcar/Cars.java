package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(int carCount, int rangeStartRandomNumber
            , int rangeEndRandomNumber, int moveCondition) {
        this.cars = IntStream
                .range(0, carCount)
                .mapToObj(count ->
                        new Car(rangeStartRandomNumber
                                , rangeEndRandomNumber
                                , moveCondition))
                .collect(Collectors.toList());
    }

    public List<Car> getInstance() {
        return cars;
    }

    public void addMove() {
        cars.forEach(Car::addMoveCount);
    }
}
