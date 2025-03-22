package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberOfTrialTest {

    @DisplayName("getNumberOfTrial 테스트")
    @Test
    void getNumberOfTrial() {
        int expected = 3;
        NumberOfTrial numberOfTrial = new NumberOfTrial(expected);
        Assertions.assertThat(numberOfTrial.getNumberOfTrial()).isEqualTo(expected);
    }

    @DisplayName("1보다 작은 숫자를 입력 받았을 경우 IllegalArgumentException")
    @Test
    void illegalArgumentExceptionTest() {
        Assertions.assertThatThrownBy(() -> new NumberOfTrial(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}