package homework.week1.racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame("pobi,crong,honux", "5");
    }

    @Test
    void 자동차이름_사용자입력예외처리() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
           new RacingCarGame("", "1");
            new RacingCarGame("pobi,,crong", "1");
            new RacingCarGame(null, "1");
            new RacingCarGame(" ", "1");
        });
    }

    @Test
    void 경주횟수_사용자입력예외처리() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCarGame("pobi,crong", "-1");
            new RacingCarGame("pobi,crong", "aaa");
            new RacingCarGame("pobi,crong", "");
            new RacingCarGame("pobi,crong", "0");
        });
    }

    @Test
    void tryRace_result_RacingCarGameResult() {
        assertThat(racingCarGame.tryRace()).isInstanceOf(RacingCarGameResult.class);
    }

    @Test
    void isFinishRace() {
        assertThat(racingCarGame.isFinishRace(4)).isFalse();
        assertThat(racingCarGame.isFinishRace(5)).isTrue();
        assertThat(racingCarGame.isFinishRace(6)).isFalse();
    }
}
