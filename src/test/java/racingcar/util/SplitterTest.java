package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SplitterTest {

    @Test
    @DisplayName(",를 구분자로하여 3개의문자를 입력하면 ,를 기준으로 3Size의 배열을 생성한다.")
    void splitString_comma() {
        String inputString = "엄태권,태권,ServerWizard";

        String[] result = Splitter.splitString(inputString);

        assertThat(result).hasSize(3);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 비어있는 문자를 입력할 경우 오류가 발생한다.")
    void splitString_empty_null(String inputString) {
        assertThatThrownBy(() -> Splitter.splitString(inputString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 한 글자 이상을 입력해야 합니다.");
    }
}