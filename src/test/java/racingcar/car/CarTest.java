package racingcar.car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("숫자가 4 이상이면 자동차는 전진한다.")
    @Test
    void move() {
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean isMovable(int number) {
                return super.isMovable(4);
            }
        });
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("숫자가 4 미만이면 자동차는 이동하지 않는다.")
    @Test
    void stop() {
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean isMovable(int number) {
                return super.isMovable(3);
            }
        });
        assertThat(car.getPosition()).isZero();
    }

}
