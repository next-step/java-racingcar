package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.movable.RandomMovableStrategy;

public class TestUtils {

    private TestUtils() {}

    static void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved: moves) {
            car.run(new RandomMovableStrategy() {
                @Override
                public boolean isMovable() {
                    return carMoved;
                }
            });
        }
    }
}
