package racingcar.util;

import racingcar.domain.Car;

public class CarStatusSetterForTest {

    private static final int MOVE_CONDITION = 4;

    public static void repeatMove(Car car, int count) {
        while (count-- > 0) {
            car.move(MOVE_CONDITION);
        }
    }
}
