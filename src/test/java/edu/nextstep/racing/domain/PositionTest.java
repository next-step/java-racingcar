package edu.nextstep.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-22 14:30
 */
public class PositionTest {

    @Test
    void 현재위치_가져오기() {
        Position position = new Position(3);
        assertThat(position.getPosition()).isEqualTo(3);
    }

    @Test
    void 자동차_이동시키기() {
        Position position = new Position();
        assertThat(position.move().getPosition()).isEqualTo(1);
    }

    @Test
    void 음수값_예외상황() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Position position = new Position(-1);
        });
    }

}
