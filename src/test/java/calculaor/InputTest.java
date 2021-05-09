package calculaor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputTest {
    private String testInput;

    @BeforeEach
    void setUP() {
        testInput = "2 + 3";
    }

    // 빈값 (null 값 or " ") 판단 테스트
    // null 값은 통과 못 함
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void checkBlank(String blankInput) {
        // given
        Input input = new Input();

        // when
        Boolean actual = input.checkBlank(blankInput);

        //then
        assertTrue(actual);
    }

    // input값 " "기준으로 split 테스트
    @Test
    void Splitter() {
        // given
        Input input = new Input();

        // when
        String[] expected = {"2", "+", "3"};
        String[] actual = input.splitter(testInput);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    // splitter 테스트할 때, 예외 처리 테스트
    @ParameterizedTest
    @ValueSource(strings = {"2 + 5", "", " "})
    void blankErrorException(String testInput) {
        assertThatThrownBy(() -> {
            // given
            Input input = new Input();

            // when
            String[] expected = {"2", "+", "5"};
            String[] actual = input.blankErrorException(testInput);

            // then
            assertThat(actual).isEqualTo(expected);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}


