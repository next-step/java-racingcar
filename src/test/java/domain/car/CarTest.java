package domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @DisplayName("자동차가 이동할 수 있는 경우 위치가 1 증가한다")
    @Test
    void move() {
        MoveStrategy moveStrategy = () -> true;
        Car car = new Car("TEST", moveStrategy);
        int position = car.getPosition().intValue();

        car.move();
        assertThat(car.getPosition().intValue()).isEqualTo(position + 1);
    }

    @DisplayName("자동차가 이동할 수 없는 경우 위치가 증가하지 않는다")
    @Test
    void notMove() {
        MoveStrategy moveStrategy = () -> false;
        Car car = new Car("TEST", moveStrategy);
        int position = car.getPosition().intValue();

        car.move();
        assertThat(car.getPosition().intValue()).isEqualTo(position);
    }

    @DisplayName("자동차 이름이 null 또는 빈문자열인 경우 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyName(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(input, () -> true))
                .withMessageMatching("유효하지 않은 이름입니다.");
    }

    @DisplayName("자동차 이름이 5자를 초과할 경우 예외가 발생한다")
    @Test
    void carCreateFail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("carNameTest", () -> true))
                .withMessageMatching("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이동거리를 비교할 수 있다")
    @Test
    void compareCarPosition() {
        Car car = new Car("Car", 1, () -> true);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
