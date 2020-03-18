package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputArrayTest {
    @DisplayName("split된 inputArray의 짝수 인덱스에 사칙연산 기호가 아닌 문자열이 오면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "%", "!", "&", "@"})
    void validateInputArrayTest(String operator) {
        //given
        String input = "1 " + operator + " 3";
        InputView inputView = new InputView(input);

        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new InputArray(inputView);
        });
    }

    @DisplayName("inputArray에서 숫자만 불러와 List를 만든다.")
    @Test
    void extractNumberTest() {
        //given
        String input = "1 + 2 - 5";
        InputView inputView = new InputView(input);

        //when
        InputArray inputArray = new InputArray(inputView);

        //then
        assertThat(inputArray.getNumbers()).hasSize(3);
        assertThat(inputArray.getNumbers().get(1)).isEqualTo(2);
    }
}