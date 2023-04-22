package race.step3;

import race.step3.domain.Car;
import race.step3.domain.MoveStrategy;

public class Fixture {
    public static Car car;

    public static MoveStrategy fakeCanNotMoveStrategy = new MoveStrategy() {
        @Override
        public boolean isMovable() {
            return randomGenerator() >= 4;
        }

        @Override
        public int randomGenerator() {
            return 2;
        }
    };

    public static MoveStrategy fakeCanMoveStrategy = new MoveStrategy() {
        @Override
        public boolean isMovable() {
            return randomGenerator() >= 4;
        }

        @Override
        public int randomGenerator() {
            return 4;
        }
    };
}
