package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.movable.RandomMovableStrategy;

public class TestUtils {

    private static final int RANDOM_BOUND = 10;

    private TestUtils() {}

    static void carMove(Car car, List<Boolean> moves) {
        for (boolean carMoved: moves) {
            car.run(new RandomMovableStrategy(RANDOM_BOUND) {
                @Override
                public boolean isMovable() {
                    return carMoved;
                }
            });
        }
    }
}
