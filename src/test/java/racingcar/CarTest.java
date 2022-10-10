package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.NumberGenerateStrategy;

class CarTest {

    @Test
    @DisplayName("주어진 숫자가 4 이상이면 자동차가 움직일 수 있는 횟수가 1 증가한다.")
    void move_numberOver4() {
        Car car = new Car("jordy", new SameNumberGenerateStrategy());
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("주어진 숫자가 4 미만이면 자동차가 움직일 수 있는 횟수가 증가하지 않는다.")
    void move_numberUnder4() {
        Car car = new Car("jordy", new NumberGenerateStrategy() {
            @Override
            public int generate() {
                return 3;
            }
        });
        car.move();

        assertThat(car.getPosition()).isZero();
    }
}