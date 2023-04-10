package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차를 생산한다.")
    @Test
    void test01() {
        Car car = Car.create();

        assertThat(car.position()).isEqualTo(Position.init());
    }

    @DisplayName("4 이상일 경우 전진한다.")
    @Test
    void test02() {
        Car car = Car.create();

        car.move(Position.MOVE_POSITION_CONDITION);

        Position position = car.position();
        assertThat(position.position()).isEqualTo(1);
    }

    @DisplayName("4 미만일 경우 움직이지 않는다.")
    @Test
    void test03() {
        Car car = Car.create();

        car.move(Position.MOVE_POSITION_CONDITION - 1);

        Position position = car.position();
        assertThat(position.position()).isEqualTo(0);
    }
}
