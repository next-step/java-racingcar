package calculator.domain;

import calculator.domain.CalculateNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculateNumberTest {

    @DisplayName("Null 체크")
    @ParameterizedTest
    @NullAndEmptySource
    void nullException(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CalculateNumber(input);
        })
                .withMessageContaining("숫자 값이 없습니다.");
    }

    @Test
    @DisplayName("숫자 포맷 체크")
    void numberFormatException() {
        assertThat(new CalculateNumber("1").number()).isEqualTo(1);
        assertThat(new CalculateNumber("2").number()).isEqualTo(2);
        assertThat(new CalculateNumber("3").number()).isEqualTo(3);
        assertThat(new CalculateNumber("4").number()).isEqualTo(4);
        assertThat(new CalculateNumber("5").number()).isEqualTo(5);
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new CalculateNumber("calculator");
        })
                .withMessageContaining("숫자가 아닙니다.");
    }

}
