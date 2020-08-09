package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Constants;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.Constants.*;

public class CarsTest {

    @DisplayName("n : 자동차 대수 입력값 없거나 0일 경우")
    @Test
    public void whenZeroOrBlankCarCount() {
        assertThatThrownBy(() ->
                Cars.func())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CAR_COUNT_ZERO_OR_BLANK);
    }

    @DisplayName("m :이동 시행 횟수 입력값 없거나 0일 경우")
    @Test
    public void whenZeroOrBlankRacingCount() {
        assertThatThrownBy(() ->
                Cars.func())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RACING_COUNT_ZERO_OR_BLANK);
    }


    }
}
