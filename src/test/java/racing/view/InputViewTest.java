package racing.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.view.InputView.validNumberOfAttempt;
import static racing.view.InputView.validNumberOfCars;

public class InputViewTest {

    @DisplayName("자동차 입력 대수 유효성 검사 테스트")
    @Test
    void validInputNumberOfCars() {
        assertThat(validNumberOfCars(0)).isFalse();
        assertThat(validNumberOfCars(3)).isTrue();
    }

    @DisplayName("시도할 횟수 유효성 검사 테스트")
    @Test
    void validInputNumberOfAttempt() {
        assertThat(validNumberOfAttempt(0)).isFalse();
        assertThat(validNumberOfAttempt(5)).isTrue();
    }
}
