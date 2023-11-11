package racewinner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racewinner.exception.InputEmptyException;
import racewinner.exception.InvalidDelimiterException;
import racewinner.exception.NegativeNumberException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @DisplayName("음수의 레이싱횟수를 입력하면 NegativeNumberException가 발생한다.")
    @Test
    void negativeNumber() {
        assertThatThrownBy(() -> new CarRacing("popo,nono", -1, null))
                .isInstanceOf(NegativeNumberException.class);
    }
    @DisplayName("','구분자 외의 다른 구분자를 사용하면 InvalidDelimiterException가 발생한다.")
    @Test
    void carNameTooLong() {
        assertThatThrownBy(() -> new CarRacing("popo:nono", 1, null))
                .isInstanceOf(InvalidDelimiterException.class);
    }
    @DisplayName("input이 null아면 InputEmptyException이 발생한다.")
    @Test
    void inputNull() {
        assertThatThrownBy(() -> new CarRacing(null, 1, null))
                .isInstanceOf(InputEmptyException.class);
    }
    @DisplayName("input이 빈 문자열이면 InputEmptyException이 발생한다.")
    @Test
    void inputEmptyString() {
        assertThatThrownBy(() -> new CarRacing("", 1, null))
                .isInstanceOf(InputEmptyException.class);
    }
}
