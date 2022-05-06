package racing_refactoring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingNameTest {

    @DisplayName("Car 객체 생성 실패 (빈값 입력)")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void construct_blankName_fail(String name) {
        assertThatThrownBy(() -> new RacingName(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다.");
    }

    @DisplayName("Car 객체 생성 실패 (5글자 이상 입력)")
    @ParameterizedTest
    @ValueSource(strings = {"longerThanFiveWord"})
    void construct_LongerThanFiveWords(String name) {
        assertThatThrownBy(() -> new RacingName(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5글자를 넘을 수 없습니다.");
    }
}