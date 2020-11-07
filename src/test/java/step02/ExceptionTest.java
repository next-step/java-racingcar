package step02;

import exception.DividedByZeroException;
import exception.EmptyException;
import exception.InValidOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import validator.HasContentsValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class ExceptionTest {
    private static Stream<Arguments> provideInValidOperatorResult() {
        return Stream.of(
                Arguments.of(Arrays.asList("3", "&", "5", ".", "2", "=", "5", "+", "10", "-", "5"))
        );
    }

    @DisplayName("사칙연산 기호에 해당되지 않을 경우 예외 처리")
    @ParameterizedTest
    @MethodSource("provideInValidOperatorResult")
    public void 유효하지않은_연산자_예외처리_테스트(List<String> inputData) {
        assertThatExceptionOfType(InValidOperatorException.class)
                .isThrownBy(() -> {
                    Calculator.calculate((String[]) inputData.toArray());
                });
    }

    @DisplayName("입력값이 null 이거나 비었을 때 예외처리")
    @ParameterizedTest
    @NullAndEmptySource
    public void 빈_입력값_예외처리_테스트(String blankData) {
        assertThatExceptionOfType(EmptyException.class)
                .isThrownBy(() -> {
                    HasContentsValidator.validate(blankData);
                });
    }

    @DisplayName("0 으로 나눌 경우 테스트")
    @ParameterizedTest
    @CsvSource(value = "10, 0")
    public void 나눗셈_0_테스트(int first, int second) {
        assertThatExceptionOfType(DividedByZeroException.class)
                .isThrownBy(() -> {
                    Operator.executeOf("/", first, second);
                });
    }

}
