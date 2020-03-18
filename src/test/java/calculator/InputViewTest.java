package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    @DisplayName("공백 또는 null을 입력받으면 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void split(String input) {
        //when, then
        assertThrows(IllegalArgumentException.class, () -> {
            new InputView(input);
        });

    }
}
