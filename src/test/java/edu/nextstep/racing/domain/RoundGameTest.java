package edu.nextstep.racing.domain;

import edu.nextstep.racing.model.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:37
 */
class RoundGameTest {

    private RoundGame game;

    @BeforeEach
    void 사전설정() {
        game = new RoundGame(new Race(10));
    }

    @Test
    void 게임경기_횟수_가져오기() {
        assertThat(game.getGameTime()).isEqualTo(10);
    }
}