package racingcar.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class SplitterTest {

    @DisplayName("','를 기준으로 텍스트 분할 테스트")
    @Test
    void textSplitTest() {
        assertThat(Splitter.splitText("ABC,DEF,EFG"))
                .contains("ABC", "DEF", "EFG");

        assertThat(Splitter.splitText("유재석,이효리,정지훈"))
                .contains("유재석", "이효리", "정지훈");
    }

    @DisplayName("입력 텍스트 길이 유효성 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",가나다라마바", "사아자차카타, PARAMETER"})
    void validateTextLengthTest(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Splitter.splitText(text));
    }

    @DisplayName("입력 텍스트 중복 체크 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"유재석,유재석,이효리", "이효리,유재석,정지훈,이효"})
    void validateDuplicatedTextTest(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Splitter.splitText(text));
    }
}
