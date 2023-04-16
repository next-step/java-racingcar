package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차가 이동할 수 있는 경우 위치가 1 증가한다")
    @Test
    void move() {
        Car car = new Car("TEST");
        Position position = car.getPosition();

        MoveStrategy moveStrategy = () -> true;
        car.move(moveStrategy);
        assertThat(car.getPosition().intValue()).isEqualTo(position.intValue() + 1);
    }

    @DisplayName("자동차가 이동할 수 없는 경우 위치가 증가하지 않는다")
    @Test
    void notMove() {
        Car car = new Car("TEST");
        Position position = car.getPosition();

        MoveStrategy moveStrategy = () -> false;
        car.move(moveStrategy);
        assertThat(car.getPosition().intValue()).isEqualTo(position.intValue());
    }

    @DisplayName("자동차 이름이 null 또는 빈문자열인 경우 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyName(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(input))
                .withMessageMatching("유효하지 않은 이름입니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다")
    @Test
    void carCreateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("carNameTest"))
                .withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
