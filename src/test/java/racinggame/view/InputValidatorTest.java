package racinggame.view;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.view.InputValidator;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidatorTest {
    @Test
    @DisplayName("input 값의 길이가 5자 초과한 경우")
    void validateCarNamesLengthInRange_moreThanFiveCharactersLength() {
        String[] input = {"reoung"};
        RuntimeException exception = assertThrows(RuntimeException.class,
                                                  () -> InputValidator.validateCarNamesLengthInRange(input));
        assertEquals("자동차 이름은 5자를 초과할 수 앖습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("input 값의 길이가 5자 이하인 경우")
    void validateCarNamesLengthInRange_lessThanFiveCharactersLength() {
        String[] input = {"pobi"};
        assertDoesNotThrow(() -> InputValidator.validateCarNamesLengthInRange(input));
    }

    @Test
    @DisplayName("input 값이 양수인 경우")
    void validatePositive_positiveInput() {
        String input = "3";
        assertDoesNotThrow(() -> InputValidator.validatePositive(input));
    }

    @ParameterizedTest
    @DisplayName("input 값이 양수가 아닌 경우")
    @ValueSource(strings = {"0", "-1", "부릉"})
    void validatePositive_zeroInput(String input) {
        RuntimeException exception = assertThrows(RuntimeException.class,
                     () -> InputValidator.validatePositive(input));
        assertEquals("시도할 횟수는 양수여야 합니다.", exception.getMessage());
    }
}
