package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.provider.ValueSource;
import racingcar.message.ErrorMessage;

class CarNameTest {

    @DisplayName("자동차명은 1자에서 5자 이하이면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void valid_car_name(String carName) {
        assertThatCode(() -> new CarName(carName))
                .doesNotThrowAnyException();
    }

    @DisplayName("자동차명이 0자 이하 6자 이상이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "abddklajgkljgaskfjaklsjfksjf"})
    void invalid_car_name(String carName) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @DisplayName("자동차명이 null이면 exception을 발생시킨다.")
    @Test
    void car_name_with_blank() {
        assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }

    @DisplayName("자동차명이 5자를 초과하면 exception을 발생시킨다.")
    @Test
    void car_name_exceed_max_length() {
        assertThatThrownBy(() -> new CarName("abcdef"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME_LENGTH);
    }
}
