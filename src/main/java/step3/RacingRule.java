package step3;

import java.util.List;
import java.util.Random;

public class RacingRule implements Rule {
    static final int CAN_GO = 4;
    Random random = new Random();

    @Override
    public void go(Car car) {
        if (castDice() >= CAN_GO) {
            car.go();
        }
    }

    @Override
    public void go(Car car, int dice) {
        if (dice >= CAN_GO) {
            car.go();
        }
    }

    @Override
    public void goCars(List<Car> cars) {
        for (Car car : cars) {
            go(car);     //or  racingRule.go(cars.get(i), racingRule.castDice());
        }
    }

    public int castDice() {
        return random.nextInt(10);
    }
}
