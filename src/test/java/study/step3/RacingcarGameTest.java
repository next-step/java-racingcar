package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingcarGameTest {
    @Test
    @DisplayName("각 자동차 획득한 숫자가 4이상인 경우 전진한다.")
    void 각_자동차_획득한_숫자가_4이상의_경우() {
        Racingcar racingcar = new Racingcar();
        assertThat(racingcar.tryToMoveForward()).isBetween(4,9);
    }
    @Test
    @DisplayName("각 자동차 획득한 숫자가 3이하인 경우 정지한다.")
    void 각_자동차_획득한_숫자가_3이하인_경우() {
        Racingcar racingcar = new Racingcar();
        assertThat(racingcar.tryToMoveForward()).isBetween(0,3);
    }
}
