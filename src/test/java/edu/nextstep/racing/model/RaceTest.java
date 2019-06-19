package edu.nextstep.racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-19 00:27
 */
class RaceTest {

    @Test
    void 라운드_횟수_초기화하여_라운드횟수_가져오기() {
        Race race = new Race(10);
        assertThat(race.getGameTime()).isEqualTo(10);
    }
    @Test
    void 라운드_횟수_초기화_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Race race = new Race(0);
        });
    }
}