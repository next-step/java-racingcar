package study.racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarsNumberTest {

    @Test
    @DisplayName("정상적인 수를 입력할 경우 자동차 수를 생성한다.")
    void createCarsNumberTest() {
        // given
        String input = "2";

        // when
        CarsNumber carsNumber = new CarsNumber(input);

        // then
        assertThat(carsNumber).isEqualTo(new CarsNumber("2"));
    }

    @Test
    @DisplayName("숫자를 입력하지 않는 경우 예외를 발생시킨다.")
    void errorWhenInputNotInt() {
        // given
        String input = "a";

        // when & then
        assertThatThrownBy(() -> new CarsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 대수는 숫자여야 합니다.");
    }

    @Test
    @DisplayName("자동차 대수가 1대 이하일 경우 예외가 발생한다.")
    void errorWhenCarsNumberUnderTwo() {
        // given
        String input = "1";

        // when & then
        assertThatThrownBy(() -> new CarsNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 대수는 2 이상 이어야 합니다.");
    }
}
