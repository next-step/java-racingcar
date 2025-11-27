package racingGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> names) {
        List<Car> list = new ArrayList<>();
        for (String name : names) {
            list.add(new Car(name));
        }
        return new Cars(list);
    }

    public void moveAll(MoveStrategy strategy) {
        for (Car car : cars) {
            car.move(strategy);
        }
    }

    private int maxPosition() {
        int max = 0;
        for (Car car : cars) {
            max = car.max(max);      // 메시지 기반 max
        }
        return max;
    }

    public List<String> winnerNames() {
        int max = maxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSame(max)) {
                winners.add(car.name());
            }
        }
        return winners;
    }

    public List<Car> asList() {
        return Collections.unmodifiableList(cars);
    }
}
