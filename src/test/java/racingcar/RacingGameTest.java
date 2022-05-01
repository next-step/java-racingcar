package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("랜덤넘버추출 체크_숫자가 0이상")
    @Test
    void 게임횟수_숫자확인_1이상() {
        assertThat(RacingGame.randomNumberExtraction()).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("랜덤넘버추출 체크_숫자가 9이하인지 확인")
    @Test
    void 게임횟수_숫자확인_9이하() {
        assertThat(RacingGame.randomNumberExtraction()).isLessThanOrEqualTo(9);
    }

    @DisplayName("전진조건 체크_4이상일 전진(true)확인")
    @Test
    void 랜덤한수_4초과인경우_확인() {
        assertThat(RacingGame.calculateDistance(4)).isEqualTo(true);
    }

    @DisplayName("전진조건 체크_4미만일 경우 멈춤(false)확인")
    @Test
    void 랜덤한수_10미만_범위확인() {
        assertThat(RacingGame.calculateDistance(3)).isEqualTo(false);
    }

    @Test
    void 이동거리_문자로출력() {
        assertThat(RacingGame.showDistance(5)).isEqualTo("-----");
    }
}
