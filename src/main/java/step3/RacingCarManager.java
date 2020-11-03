package step3;

import step3.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarManager {
    private List<Car> joinCarList;
    private MoveStrategy moveStrategy;

    public RacingCarManager(MoveStrategy moveStrategy) {
        if (moveStrategy == null) {
            throw new NullPointerException(ErrorMessage.MOVE_STRATEGY_IS_NULL);
        }
        this.moveStrategy = moveStrategy;
    }

    public void joinCars(int carCount) {
        List<Car> list = new ArrayList<>();
        IntStream.range(0, carCount).forEach(i -> {
            list.add(new Car());
        });
        joinCarList = Collections.unmodifiableList(list);
    }

    public void moveCars() {
        joinCarList
                .forEach(car -> {
                    int generate = moveStrategy.generate();
                    car.move(generate);
                });
    }

    public List<Integer> getRacingStatus() {
        return joinCarList
                .stream()
                .map(Car::getLocation)
                .collect(Collectors.toList());
    }
}
