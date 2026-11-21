package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 움직일_수_있으면_위치가_1_증가한다() {
        Car car = new Car("pobi");

        car.move(new FakeMoveStrategy(true));

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 움직일_수_없으면_위치가_그대로다() {
        Car car = new Car("pobi");

        car.move(new FakeMoveStrategy(false));

        assertThat(car.getPosition()).isEqualTo(0);
    }


    private static class FakeMoveStrategy implements MoveStrategy {
        private boolean canMove;
        public FakeMoveStrategy(boolean canMove) {
            this.canMove = canMove;
        }
        @Override
        public boolean movable() {
            return canMove;
        }
    }
}