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
    @DisplayName("이름 유효성 검사 : ,로 분리 여부")
    @ParameterizedTest
    @ValueSource(strings = "aaaaa,bbbbb,ccccc")
    void splitCarNames(String carNames) {
        String[] splitCarNames = InputView.splitNameOfCars(carNames);
        assertThat(splitCarNames).isEqualTo(new String[]{"aaaaa", "bbbbb", "ccccc"});
    }

    @DisplayName("시도 횟수 값 유효성 검사")
    @ParameterizedTest
    @MethodSource("inputLoopCount")
    void validInputNum(boolean expect, int inputLoopCountNumber) {
        assertThat(InputView.isValidLoopCountNumber(inputLoopCountNumber)).isEqualTo(expect);
    }

    private static Stream<Arguments> inputLoopCount() {
        return Stream.of(
                Arguments.of(false, 7),
                Arguments.of(true, 0)
        );
    }

    @DisplayName("시도 횟수 값 유효성 검사 : 숫자외의 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "foo"})
    void validInputValue(String exceptionWord) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                InputView.validateLoopCountNumber(Integer.parseInt(exceptionWord)));

    }
}