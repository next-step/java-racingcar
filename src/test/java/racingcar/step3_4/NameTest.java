package racingcar.step3_4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step3_4.domain.Name;

class NameTest {

    @DisplayName("자동차 이름 설정")
    @Test
    void createTest() {
        Name result = new Name("pobi");

        assertThat(result).isEqualTo(new Name("pobi"));
    }

    @DisplayName("이름이 5자를 초과할 경우 예외 발생")
    @Test
    void greaterThanFiveCharactersTest() {
        assertThatThrownBy(() -> new Name("abcdef"))
            .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈문자열로 자동차 이름 설정 시 예외 발생")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void createBlankNameTest(String value) {
        assertThatThrownBy(() -> new Name(value)).isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
