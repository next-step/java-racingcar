package step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.exception.RacingCarValidationException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarTest {

    @Test
    @DisplayName("자동차의 이름은 null일 수 없다")
    void nameIsNotNull() {
        assertThatThrownBy(() -> new RacingCar(null))
                .isInstanceOf(RacingCarValidationException.class)
                .hasMessage("이름은 null일 수 없습니다");
    }

    @Test
    @DisplayName("자동차의 이름은 5글자 초과일 수 없다")
    void nameLengthTest() {
        assertThatThrownBy(() -> new RacingCar("123456"))
                .isInstanceOf(RacingCarValidationException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다");
    }

    @Test
    @DisplayName("5글자 이하로 자동차를 생성할 수 있다")
    void createSuccess() {
        RacingCar racingCar = new RacingCar("12345");
    }

    @Test
    @DisplayName("생성한 이름을 조회할 수 있다")
    void getName() {
        // given
        RacingCar racingCar = new RacingCar("12345");

        // when
        String name = racingCar.getName().stringValue();

        // then
        Assertions.assertThat(name).isEqualTo("12345");
    }
}
