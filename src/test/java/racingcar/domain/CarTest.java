package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("toby");
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과하면 예외가 발생한다.")
    void name() {
        // given
        // when
        Assertions.assertThatThrownBy(() -> new Car("kimbro", 0))
                .isInstanceOf(IllegalArgumentException.class);
        // then
    }

    @Test
    @DisplayName("자동차 이동 가능 여부가 true 값이면 이동할 수 있다.")
    void move_O() {
        // when
        car.move(new MoveStrategy() {
            @Override
            public boolean moveAble() {
                return true;
            }
        });
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이동 가능 여부가 false 값이면 이동할 수 없다.")
    void move_X() {
        // when
        car.move(() -> false);
        // then
        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }
}
