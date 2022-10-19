package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Racing : 양의 정수 입력 테스트")
public class RacingInputViewTest {

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("validInputs_for_getPositiveIntegerInputTest")
    @DisplayName("양의 정수 데이터 입력")
    void getPositiveIntegerInput_witValidInput_test(String input, Integer output, String testName) {
        Scanner scanner = generateInputScanner(input);
        assertThat(RacingInputView.getPositiveIntegerInput(scanner)).isEqualTo(output);
    }

    @ParameterizedTest(name = "{index}: {2}")
    @MethodSource("invalidInputs_for_getPositiveIntegerInputTest")
    @DisplayName("양의 정수가 아닌 데이터 입력")
    void getPositiveIntegerInput_witInvalidInput_test(String input, Class exceptionClass, String testName) {
        Scanner scanner = generateInputScanner(input);
        assertThatThrownBy(() -> RacingInputView.getPositiveIntegerInput(scanner))
                .isInstanceOf(exceptionClass);
    }

    private Scanner generateInputScanner(String input) {
        InputStream in = generateUserInput(input);
        System.setIn(in);
        return new Scanner(System.in);
    }

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> validInputs_for_getPositiveIntegerInputTest() {
        return Stream.of(
                Arguments.of("1", 1, "양의 정수 입력시 올바르게 반환"),
                Arguments.of("100", 100, "양의 정수 입력시 올바르게 반환")
        );
    }

    private static Stream<Arguments> invalidInputs_for_getPositiveIntegerInputTest() {
        return Stream.of(
                Arguments.of("0", InputMismatchException.class, "0이나 음의 정수 입력시 에러 발생"),
                Arguments.of("-1", InputMismatchException.class, "0이나 음의 정수 입력시 에러 발생"),
                Arguments.of("abc", InputMismatchException.class, "정수가 아닌 데이터 입력시 에러 발생"),
                Arguments.of("1.23", InputMismatchException.class, "정수가 아닌 데이터 입력시 에러 발생"),
                Arguments.of("", NoSuchElementException.class, "공백 입력시 에러 발생"),
                Arguments.of("  ", NoSuchElementException.class, "공백 입력시 에러 발생")
        );
    }
}
