package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_랜덤값4이상인경우_자동차는_전진한다() {
        MoveStrategy trueMoveStrategy = () -> true;
        Car car = new Car("test1", trueMoveStrategy);
        car.move();

        assertThat(car).isEqualTo(new Car("test1", 1, trueMoveStrategy));
    }

    @Test
    void move_랜덤값4미만인경우_자동차는_현위치를유지한다() {
        MoveStrategy falseMoveStrategy = () -> false;
        Car car = new Car("test1", falseMoveStrategy);
        car.move();

        assertThat(car).isEqualTo(new Car("test1", falseMoveStrategy));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmptyName(String name) {
        Assertions.assertThatThrownBy(() -> new Car(name, () -> false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void exceedNameLength() {
        Assertions.assertThatThrownBy(() -> new Car("여섯자리이름", () -> false))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
