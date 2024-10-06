package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.AttemptResult;
import racingcar.dto.RaceResult;
import racingcar.mock.TestRandomHolder;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame("pobi,catsb,hoya", new FourOrMore(new TestRandomHolder(4)));
    }

    @Test
    @DisplayName("시도 횟수별 자동차의 위치와 우승자를 반환한다.")
    void race() {
        RaceResult raceResult = racingGame.race(1);
        assertThat(raceResult.getAttemptResults()).isEqualTo(List.of(new AttemptResult(List.of(new Car(1, "pobi"), new Car(1, "catsb"), new Car(1, "hoya")))));
        assertThat(raceResult.getWinners()).isEqualTo(List.of("pobi", "catsb", "hoya"));
    }
}
