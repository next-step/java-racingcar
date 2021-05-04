package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReceivingRacingGameInputTest {
    private ReceivingRacingGameInput receivingRacingGameInput;

    @DisplayName("입력 값이 null 또는 empty인 경우 재입력 요청하여 NoSuchElementException 발생")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"123a", "abc", "a358"})
    public void case_when_input_value_is_not_number_throw_NoSuchElementException(String inputValue) {
        receivingRacingGameInput = new ReceivingRacingGameInput(new Scanner(inputValue));
        assertThrows(NoSuchElementException.class, () -> receivingRacingGameInput.receiveRoundNumber());
    }

    @DisplayName("숫자만 입력시 테스트 성공")
    @ParameterizedTest(name = "{index} {displayName} input value={0}")
    @ValueSource(strings = {"5", "25"})
    public void case_when_receive_only_numbers(String inputValue) {
        receivingRacingGameInput = new ReceivingRacingGameInput(new Scanner(inputValue));
        assertDoesNotThrow(() -> receivingRacingGameInput.receiveRoundNumber());
    }

}
