package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carracing.exceptions.InvalidNameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("자동차의 이름이 5자를 초과할 시 예외가 발생한다.")
    void carNameLength() {
        assertThatThrownBy(() -> new Name("racingcar"))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("자동차의 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차의 이름이 공백일 시 예외가 발생한다.")
    void carNameBlank() {
        assertThatThrownBy(() -> new Name(" ".trim()))
                .isInstanceOf(InvalidNameException.class)
                .hasMessageContaining("자동차의 이름이 입력되지 않았습니다.");
    }
}