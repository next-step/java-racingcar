package racingcar;

import racingcar.interfaces.MoveStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {

    private final List<Car> cars;

    public Cars(int input) {
        cars = new ArrayList<>();
        for (int i=0; i < input; i++) {
            cars.add(new Car());
        }
    }

    public int size() {
        return this.cars.size();
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }

    public void tryMove(int input, MoveStrategy moveStrategy) {
        for (int i=0; i < input; i++) {
            orderMoveOneCycle(moveStrategy);
        }
    }

    public void orderMoveOneCycle(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy.getMoveNumber());
        }
    }
}
