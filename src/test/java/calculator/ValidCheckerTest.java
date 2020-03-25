package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidCheckerTest {
    private static final String INPUT_DELIMITER = " ";

    @ParameterizedTest
    @NullSource
    @DisplayName("입력 값이 null 일 경우 IllegalArgumentException throw 테스트")
    public void nullInputThrowExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidChecker.checkValidInput(input);
        });
    }

    @ParameterizedTest
    @MethodSource("generateInvalidCountInputsArray")
    @DisplayName("입력 값의 갯수가 연산이 불가능한 문자일 경우 IllegalArgumentException throw 테스트")
    public void invalidInputThrowExceptionTest(List<String> inputList) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidChecker.checkInputCountComputable((String[]) inputList.toArray());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("연산자가 유효한 경 테스트")
    public void checkValidOperationTest(String input) {
        assertDoesNotThrow(() -> {
            ValidChecker.checkValidOperation(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"@", "1", "d"})
    @DisplayName("연산자가 유효하지 않은 경우 IllegalArgumentException throw 테스트")
    public void IllegalOperandFormatThrowExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            ValidChecker.checkValidOperation(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "-3"})
    @DisplayName("피연산자가 유효한 경 테스트")
    public void checkValidOperandTest(String input) {
        assertDoesNotThrow(() -> ValidChecker.checkValidOperand(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "*", " "})
    @DisplayName("피연산자가 숫자가 아닌 경우 IllegalArgumentException throw 테스트")
    public void illegalOperatorInputThrowExceptionTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
             ValidChecker.checkValidOperand(input);
        });
    }

    private static Stream<Arguments> generateInvalidCountInputsArray() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList("1")),
                Arguments.of(Arrays.asList("1","+","2","*"))
        );
    }
}
