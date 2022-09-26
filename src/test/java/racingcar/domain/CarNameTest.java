package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름이 빈값이면 에러")
    @NullAndEmptySource
    void car_name_null_or_empty(String input) {
        assertThatThrownBy(() -> new CarName(input))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름이 공백 문자열이면 에러 ")
    void car_name_blank() {
        assertThatThrownBy(() -> new CarName(" "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("빈 값");
    }

    @Test
    @DisplayName("자동차 이름에 공백이 있으면 에러 ")
    void car_name_contain_blank() {
        assertThatThrownBy(() -> new CarName("a b"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("공백");
    }


    @Test
    @DisplayName("자동차 이름이 5를 넘어가면 에러")
    void car_name_size_over_5() {
        assertThatThrownBy(() -> new CarName("asdfgef"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("5");

    }

}