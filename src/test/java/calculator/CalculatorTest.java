package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;


class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "        "})
    @DisplayName(value = "String이 null or 공백 데이터일 경우 isBlack true")
    public void isBlank_ShouldReturnTrue(String str) {
        assertThat(str == null || str.trim().isEmpty()).isTrue();
    }


}