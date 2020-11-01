package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private List<Car> cars;

    public List<Car> readyCars(int num, MoveStrategy moveStrategy) {
        this.cars = IntStream.range(0, num)
                .mapToObj(i -> new Car(moveStrategy))
                .collect(Collectors.toList());

        return cars;
    }

    public void play() {
        cars.stream().forEach(c -> c.move());
    }
}
