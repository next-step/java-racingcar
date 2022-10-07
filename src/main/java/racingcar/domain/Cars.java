package racingcar.domain;

import racingcar.condition.MoveCondition;
import racingcar.condition.RandomMoveCondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 많은 차와 관련된 객체
 */
public class Cars {
    private List<String> name;
    private int tryNum;
    private MoveCondition moveCondition;
    private List<Car> cars;

    public Cars(List<String> name, MoveCondition moveCondition) {
        this.cars = makeCars(name, moveCondition);
    }

    public Cars(List<String> name, int tryNum, MoveCondition moveCondition) {
        this.cars = makeCars(name, moveCondition);
        this.tryNum = tryNum;
        this.moveCondition = moveCondition;
    }

    public static List<Car> makeCars(List<String> name, MoveCondition moveCondition) {
        List<Car> cars = new ArrayList<>();
        int nameNum = name.size();
        for (int i = 0; i < nameNum; i++) {
            cars.add(new Car(name.get(i), moveCondition));
        }
        return cars;
    }

    public boolean racing() {
        return this.tryNum > 0;
    }

    public void race() {
        this.tryNum--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(moveCondition);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        return Winners.findWinners(cars);
    }
}
