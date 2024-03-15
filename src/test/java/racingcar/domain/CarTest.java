package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @Test
    @DisplayName("생성자에 자연수를 전달하면, 정상적으로 Car 객체가 생성된다.")
    void new_PositiveNumber_NewCar() {
        final int number = 1;
        final Car newCar = new Car(number);

        assertThat(newCar.number())
                .isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성자에 0 혹은 음의 정수를 전달하면, 예외를 던진다.")
    void new_NegativeOrZeroNumber_Exception(final int negativeOrZeroNumber) {
        assertThatThrownBy(() -> new Car(negativeOrZeroNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 번호는 자연수만 가능합니다.");
    }
}
