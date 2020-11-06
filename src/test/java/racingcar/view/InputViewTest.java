package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class InputViewTest {
    @DisplayName("Input number 값 유효성 검사")
    @ParameterizedTest
    @MethodSource("inputNumberCase")
    void validInputNum(boolean expect, int inputNumber) {
        assertThat(InputView.isValidInputNumber(inputNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputNumberCase() {
        return Stream.of(
                Arguments.of(false, 7),
                Arguments.of(true, 0)
        );
    }

    @DisplayName("Input 값 유효성 검사 : 숫자외의 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "foo"})
    void validInputValue(String exceptionWord) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                InputView.validateInputNum(Integer.parseInt(exceptionWord)));
    }
}
