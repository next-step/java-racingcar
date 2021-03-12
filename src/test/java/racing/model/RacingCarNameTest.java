package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarNameTest {

    @DisplayName("자동차 이름이 비었을 때")
    @Test
    void CarNameEmptyValid() {
        assertThatThrownBy(() -> {
            RacingCarName racingCarName = new RacingCarName("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 필수입니다.");
    }

    @DisplayName("자동차 이름이 5글자 초과했을때")
    @Test
    void carNameLengthValid() {
        assertThatThrownBy(() -> {
            RacingCarName racingCarName = new RacingCarName("singsing");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("자동차 이름은 5글자를 초과할 수 없습니다.");
    }
}