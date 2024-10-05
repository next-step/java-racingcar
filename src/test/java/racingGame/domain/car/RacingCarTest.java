package racingGame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    private static final String CAR_NAME = "Car";

    @Test
    @DisplayName("자동차 이름이 5글자 이하면 정상적으로 생성된다.")
    void createCarWithValidName() {
        RacingCar car = new RacingCar(CAR_NAME, () -> true);
        assertThat(car.getName()).isEqualTo(CAR_NAME);
    }

    @ParameterizedTest
    @ValueSource(strings = {"car123", "longname"})
    @DisplayName("자동차 이름이 5글자를 초과하면 예외가 발생한다.")
    void throwExceptionForLongName(String invalidName) {
        assertThatThrownBy(() -> new RacingCar(invalidName, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름이 null 또는 빈문자이면 예외가 발생한다.")
    void throwExceptionForNullNameOrEmpty(String invalidName) {
        assertThatThrownBy(() -> new RacingCar(invalidName, () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 조건이 만족하면 움직인다.")
    @Test
    void move() {
        RacingCar car = new RacingCar(CAR_NAME, () -> true);

        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("이동 조건이 만족하지 않으면 움직이지 않는다.")
    @Test
    void stop() {
        RacingCar car = new RacingCar(CAR_NAME, () -> false);

        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

}