package study.racing;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

    private List<Car> cars;

    public Cars(String[] carNames) {
        this.cars = IntStream.range(0, carNames.length)
                .mapToObj(car -> new Car(carNames[car]))
                .collect(Collectors.toList());
    }

    public void move(RacingMoveStrategy racingMoveStrategy) {
        cars.forEach(car -> car.move(racingMoveStrategy));
    }

    public List<Car> getCarSet() {
        return cars;
    }

}
