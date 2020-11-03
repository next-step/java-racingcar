package step3;

import step3.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarList {

    private List<Car> racingCarList;

    public RacingCarList(int carCount) {
        List<Car> list = new ArrayList<>();
        IntStream.range(0, carCount).forEach(i -> {
            list.add(new Car());
        });
        racingCarList = Collections.unmodifiableList(list);
    }

    public void moveCars(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new NullPointerException();
        }
        racingCarList
                .forEach(car -> {
                    int generate = moveStrategy.generate();
                    car.move(generate);
                });
    }

    public List<Integer> getRacingStatus() {
        return racingCarList
                .stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }
}
