package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class NumberUtilTest {

    @DisplayName("Input 값을 넣을시 int로 변환하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "6"})
    void toInt(String inputNumber) {
        assertThat(NumberParserUtil.toInt(inputNumber)).isExactlyInstanceOf(Integer.class);
    }

    @Test
    void toIntException() {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
                   NumberParserUtil.toInt("rk");
                }
        ).withMessage("Missmatch integer type");
    }

}