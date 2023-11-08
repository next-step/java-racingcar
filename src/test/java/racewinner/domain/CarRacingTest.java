package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.expteion.NegativeNumberException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @DisplayName("음수의 레이싱횟수를 입력하면 NegativeNumberException가 발생한다.")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> new CarRacing(null, -1))
                .isInstanceOf(NegativeNumberException.class);
    }
}
