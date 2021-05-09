package calculaor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputTest {
    private String testInput;

    @BeforeEach
    void setUP() {
        testInput = "2 + 3";
    }

    // 빈값 (null 값 or " ") 판단 테스트
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void checkBlankTest(String blankInput) {
        // given
        Input input = new Input();

        // when
        Boolean actual = input.checkBlank(blankInput);

        //then
        assertTrue(actual);
    }

    // split 테스트
    @Test
    void isSplitTest() {
        // given
        Input input = new Input();

        // when
        String[] expected = {"2", "+", "3"};
        String[] actual = input.isSplit(testInput);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    // 예외상황(빈값 들어왔을 때) 테스트
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void splitExceptionTest(String testValue) {
        // given
        Input input = new Input();

        //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> input.splitException(testValue));
    }
}
