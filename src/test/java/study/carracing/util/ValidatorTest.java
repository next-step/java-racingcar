package study.carracing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    @DisplayName("형식에 맞지 않는 자동차의 이름을 입력할 시 IllegalArgumentException예외가 발생한다.")
    void carsNamePattern() {
        assertThatThrownBy(() -> Validator.validateCarName("wrong pattern"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("형식에 맞지 않는 값이 입력됐습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 5자를 초과할 시 RunTimeException이 발생한다.")
    void carNameLength() {
        assertThatThrownBy(() -> Validator.validateCarName("racingcar,pobi"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
}
