package study.carrace.step3.domain;

import org.junit.jupiter.api.Test;
import study.carrace.step3.domain.exception.IllegalCarNameException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {
    @Test
    void name_longer_than_5_characters_then_throw_IllegalCarNameException() {
        // given
        String invalidName = "more_than_five_character";

        // when, then
        assertThatThrownBy(() -> new CarName(invalidName))
                .isInstanceOf(IllegalCarNameException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다: " + invalidName);
    }
}