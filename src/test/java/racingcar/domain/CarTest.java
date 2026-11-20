package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 랜덤_값이_4_이상이면_위치가_1_증가한다() {
        Car car = new Car("pobi");

        car.move(new RandomMoveStrategy(new FixedRandomGenerator(4)));

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 랜덤_값이_4_미만이면_위치가_그대로다() {
        Car car = new Car("pobi");

        car.move(new RandomMoveStrategy(new FixedRandomGenerator(3)));

        assertThat(car.getPosition()).isEqualTo(0);
    }
}