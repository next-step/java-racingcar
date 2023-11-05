package racewinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.expteion.InputEmptyException;
import racewinner.expteion.InvalidDelimiterException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {
    @DisplayName("','구분자 외의 다른 구분자를 사용하면 InvalidDelimiterException가 발생한다.")
    @Test
    void carNameTooLong() {
        assertThatThrownBy(() -> new CarRacing("pobi:crong"))
                .isInstanceOf(InvalidDelimiterException.class);
    }

    @DisplayName("input이 null아면 InputEmptyException이 발생한다.")
    @Test
    void inputNull() {
        assertThatThrownBy(() -> new CarRacing(null))
                .isInstanceOf(InputEmptyException.class);
    }

    @DisplayName("input이 빈 문자열이면 InputEmptyException이 발생한다.")
    @Test
    void inputEmptyString() {
        assertThatThrownBy(() -> new CarRacing(""))
                .isInstanceOf(InputEmptyException.class);
    }
}
