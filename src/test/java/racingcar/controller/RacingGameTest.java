package racingcar.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {
    private List<String> carNames;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList("yong", "pobi", "crong", "honux");
        racingGame = new RacingGame(carNames);
    }

    @Test
    void RacingGame은_자동차_이름들로_생성한다() {
        assertThat(racingGame).isInstanceOf(RacingGame.class);
    }

    @Test
    void 한_단계_레이싱을_진행할_수_있다() {
        assertThat(racingGame.raceOneStep()).hasSize(carNames.size());
    }

    @Test
    void 우승자를_판별할_수_있다() {
        assertThat(racingGame.awards()).hasSize(4);
    }
}