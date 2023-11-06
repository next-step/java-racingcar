package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.strategy.TestMove;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("성공 - 0 ~ 3 값이면 자동차는 움직이지 않는다.")
    void success_not_moving_cars(int random) {
        // given
        Car car = new Car("a", new TestMove(random));

        // when
        car.moving();

        // then
        assertThat(car)
                .extracting("position")
                .isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("성공 - 4 ~ 9 값이면 자동차는 1번 움직인다.")
    void success_moving_cars(int random) {
        // given
        Car car = new Car("a", new TestMove(random));

        // when
        car.moving();

        // then
        assertThat(car)
                .extracting("position")
                .isEqualTo(1);
    }

}
