package study.racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    RacingGame racingGame;
    int round;

    @BeforeEach
    void init() {
        round = 3;
        racingGame = new RacingGame("pobi,crong,honux".split(","), round);
    }

    @Test
    void 레이싱게임에_차량들을_참가시킬수있다() {
        assertThat(racingGame.getRacingCars()).hasSize(3);
    }

    @Test
    void 레이싱게임은_입력한_회차만큼_진행된다() {
        racingGame.race();
        assertThat(racingGame.getRacingRecord().getTotalRound()).isEqualTo(round);

    }
}
