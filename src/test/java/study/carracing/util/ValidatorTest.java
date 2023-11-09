package study.carracing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carracing.exceptions.InvalidNameException;
import study.carracing.exceptions.InvalidNumberException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("숫자 이외의 값 또는 음수 입력 시 예외가 발생한다.")
    void validateNumber() {
        assertThatThrownBy(() -> Validator.validateNumber(-1))
                .isInstanceOf(InvalidNumberException.class);
    }

    @Test
    @DisplayName("형식에 맞지 않는 자동차의 이름을 입력할 시 IllegalArgumentException예외가 발생한다.")
    void carsNamePattern() {
        assertThatThrownBy(() -> Validator.validateCarName("wrong pattern"))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("형식에 맞지 않는 값이 입력됐습니다.");
    }
}
