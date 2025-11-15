package calculator;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    private Calculator calculator;

    static Stream<Arguments> sumTestCases() {
        return Stream.of(
                Arguments.of("1,2", 3),
                Arguments.of("3,4", 7),
                Arguments.of("5,6", 11),
                Arguments.of("7:8", 15),
                Arguments.of("9:10", 19)
        );
    }

    static Stream<Arguments> customDelimiterTestCases() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//$\n4$5$6", 15),
                Arguments.of("//#\n7#8#9", 24),
                Arguments.of("//@\n10@11@12", 33)
        );
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator(Delimiter.ofDefault());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다")
    void add_isSingleNumberForNullOrEmptyStrings(
            String input
    ) {
        assertThat(calculator.calculate(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5"})
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
    void add_ShouldReturnNumberForSingleNumberString(
            String input
    ) {
        int result = calculator.calculate(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @MethodSource("sumTestCases")
    @DisplayName("숫자 두개를 컴마(,) 또는 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void add_ShouldReturnSumForTwoNumbers(
            String input,
            int expected
    ) {
        int sum = calculator.calculate(input);

        assertThat(sum).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "4:5,6", "7,8:9", "10,11:12"})
    @DisplayName("구분자는 컴마(,)와 콜론(:)을 사용할 수 있다")
    void add_ShouldHandleCommaAndColonAsDelimiters(
            String input
    ) {
        assertThatCode(() -> {
            calculator.calculate(input);
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @MethodSource("customDelimiterTestCases")
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void add_ShouldHandleCustomDelimiter(
            String input,
            int expected
    ) {
        // Arrange
        Calculator customCalculator = new Calculator(Delimiter.ofCustom(input));
        String numbers = input.substring(input.indexOf("\n") + 1);

        // Act
        int sum = customCalculator.calculate(numbers);

        // Assert
        assertThat(sum).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "4,-5,6", "7,8,-9"})
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다")
    void add_ShouldThrowExceptionForNegativeNumbers(
            String input
    ) {
        assertThatThrownBy(() -> {
            calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
