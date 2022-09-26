package racingcar;

import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RoundCars {
    private final List<Car> cars = new ArrayList<>();

    public RoundCars(int carNums) {
        for (int i = 0; i < carNums; i++) {
            cars.add(new Car());
        }
    }

    public void moveCars(RacingRecord racingRecord) {
        for (Car car : cars) {
            int conditionValue = RandomUtil.generateRandomValue(ForwardCondition.LOWEST_BOUND, ForwardCondition.HIGHEST_BOUND);
            car.forwardCarByCondition(conditionValue);
            racingRecord.addCarPosition(car.getPosition());
        }
    }
}
