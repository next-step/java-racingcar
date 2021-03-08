package step3.core;

import step3.domain.Car;
import step3.move.ConditionMoveStrategy;
import step3.move.MoveStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static step3.util.Constants.START_IDX;

/**
 * 자동차의 생성을 관리할 클래스
 */
public class CarManage {

    private final List<Car> cars = new ArrayList<>();

    // 자동차 댓수만 설정
    public CarManage(int carCount) {
        this(carCount, new ConditionMoveStrategy());
    }

    // 자동차 움직이는 전략과 함께 생성하려는 경우
    public CarManage(int carCount, MoveStrategy conditionMoveStrategy) {
        createdCars(carCount, conditionMoveStrategy);
    }

    private void createdCars(int carCount, MoveStrategy conditionMoveStrategy) {
        IntStream.range(START_IDX, carCount)
                .forEach(value -> cars.add(new Car(conditionMoveStrategy)));
    }

    public void race() {
        cars.forEach(Car::move);
    }

    public List<Car> getCars() {
        return cars;
    }
}
