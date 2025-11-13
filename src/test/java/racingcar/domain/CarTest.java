package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.random.RandomNumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @Test
    void 생성자_정상적으로_생성되면_올바른_초기_상태() {
        Car car = new Car("자동차");

        assertThat(car.toSnapshot().name()).isEqualTo("자동차");
        assertThat(car.toSnapshot().distance()).isZero();
    }

    @Test
    void move_랜덤값이_3_이하이면_정지한다() {
        Car car = new Car("자동차");
        RandomNumberGenerator generator = () -> new RandomNumber(3);

        car.move(generator);

        assertThat(car.toSnapshot().distance()).isZero();
    }

    @Test
    void move_랜덤값이_4_이상이면_전진한다() {
        Car car = new Car("자동차");
        RandomNumberGenerator generator = () -> new RandomNumber(4);

        car.move(generator);

        assertThat(car.toSnapshot().distance()).isEqualTo(1);
    }

    @Test
    void toSnapshot_현재_상태를_스냅샷으로_변환한다() {
        Car car = new Car("자동차");

        assertThat(car.toSnapshot().name()).isEqualTo("자동차");
        assertThat(car.toSnapshot().distance()).isEqualTo(0);
    }
}
