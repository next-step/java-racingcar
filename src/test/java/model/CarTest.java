package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_이동전략이true인경우_자동차는_전진한다() {
        Car car = new Car("test1");
        Car moved = car.move(() -> true);

        assertThat(moved).isEqualTo(new Car("test1", 1));
    }

    @Test
    void move_이동전략이false인경우_자동차는_현위치를유지한다() {
        Car car = new Car("test1");
        Car moved = car.move(() -> false);

        assertThat(moved).isEqualTo(new Car("test1"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyName(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceedNameLength() {
        Assertions.assertThatThrownBy(() -> new Car("여섯자리이름"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
