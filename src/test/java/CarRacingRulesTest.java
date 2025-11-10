import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarRacingRulesTest {

    @Test
    @DisplayName("0에서 9 사이의 무작위 숫자를 반환한다.")
    public void randomRange() {
        assertThat(CarRacingRules.randomRange()).isBetween(0, 9);
    }

    @Test
    @DisplayName("0~9 사이 숫자를 입력받아 4 이상이면 전진, 미만이면 멈춘다.")
    public void goForwardOrStop() {
        assertThat(CarRacingRules.determineToGoForwardOrStop(5)).isTrue();
        assertThat(CarRacingRules.determineToGoForwardOrStop(2)).isFalse();
    }
}