package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;

public class StringAdditionCalculatorTest {

    StringAdditionCalculator stringAdditionCalculator = new StringAdditionCalculator();

    @ParameterizedTest
    @ValueSource(strings = {""})
    @NullAndEmptySource
    @DisplayName(" 빈 문자열 또는 null 값을 입력할 경우 True 반환")
    void checkNullOrEmpty_ReturnTrue (String input) {
        boolean result = stringAdditionCalculator.checkNullOrEmpty(input);

        assertThat(result).isTrue();
    }
}
