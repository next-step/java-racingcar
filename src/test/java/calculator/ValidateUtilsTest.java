package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ValidateUtilsTest {

    @ParameterizedTest
    @MethodSource("provideStringArrayForIsValidateInput")
    void validateInput(String[] inputArray, boolean expected) {
        assertEquals(expected, ValidateUtils.validateInput(inputArray));
    }

    private static Stream<Arguments> provideStringArrayForIsValidateInput() {
        return Stream.of(
            Arguments.of(new String[]{" ", " ", " "}, false),
            Arguments.of(new String[]{"2", "3", "4"}, false),
            Arguments.of(new String[]{"+", "*", "-"}, false),
            Arguments.of(new String[]{"+", "2", "-"}, false),
            Arguments.of(new String[]{"+", "2", "-", "*"}, false),
            Arguments.of(new String[]{"2", "*", "3", "-", "4", "/", "2"}, true)
        );
    }
}
