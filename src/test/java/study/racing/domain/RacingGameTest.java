package study.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;

    @BeforeEach
    void init() {
        racingGame = new RacingGame();
    }
    @Test
    void 레이싱게임에_차량들을_참가시킬수있다() {
        racingGame.participate("pobi,crong,honux".split(","));
        assertThat(racingGame.getRacingCars()).hasSize(3);
    }

    @Test
    void 레이싱게임은_입력한_회차만큼_진행된다() {
        int loopCount = 3;
        racingGame.participate("pobi,crong,honux".split(","));
        racingGame.race(3);

        assertThat(racingGame.getRacingRecord().getTotalRound()).isEqualTo(loopCount);

    }
}
