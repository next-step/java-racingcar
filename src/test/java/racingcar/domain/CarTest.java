package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차를 생산한다.")
    @Test
    void test01() {
        Car car = Car.create("rang");

        assertThat(car.name()).isEqualTo(new Name("rang"));
        assertThat(car.position()).isEqualTo(Position.init());
    }

    @DisplayName("자동차의 이름은 5글자를 넘길 수 없다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> Car.create("saerang"))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("4 이상일 경우 전진한다.")
    @Test
    void test03() {
        Car car = Car.create("rang");

        car.move(Position.MOVE_POSITION_CONDITION);

        Position position = car.position();
        assertThat(position.position()).isEqualTo(1);
    }

    @DisplayName("4 미만일 경우 움직이지 않는다.")
    @Test
    void test04() {
        Car car = Car.create("rang");

        car.move(Position.MOVE_POSITION_CONDITION - 1);

        Position position = car.position();
        assertThat(position.position()).isEqualTo(0);
    }
}
