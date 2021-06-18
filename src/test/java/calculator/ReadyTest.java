package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class ReadyTest {
    private final Ready ready = new Ready();
    private String testInput;

    @BeforeEach
    void setUP() {
        testInput = "2 + 3";
    }

    @Test
    @DisplayName("정상 케이스 : 수학 연산식 만들기 테스트")
    void splitterTest() {
        // given
        String[] expected = {"2", "+" ,"3"};
        String[] actual = ready.splitMathQuiz(testInput);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("예외 케이스 : null 값 입력된 경우")
    void isSplitExceptionTest(String testValue) {
        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ready.splitMathQuiz(testValue));
    }
}
