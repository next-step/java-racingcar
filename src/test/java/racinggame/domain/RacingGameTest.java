package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.result.RacingGameResult;
import racinggame.dto.RacingGameInfo;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class RacingGameTest {

    @DisplayName("레이싱게임을 수행하면 모든 경기의 게임결과 스냅샷리스트를 반환한다")
    @Test
    void racingGame() {
        //given
        String participantsCars = "a, b, c";
        int numberOfAttempt = 3;
        RacingGameInfo racingGameInfo = new RacingGameInfo(participantsCars, String.valueOf(numberOfAttempt));
        RacingGame racingGame = new RacingGame(racingGameInfo);

        //when
        RacingGameResult racingGameResult = racingGame.raceWith(new TestSwitchEngine());

        //then
        assertAll(
                () -> assertThat(racingGameResult.getResults().size()).isEqualTo(numberOfAttempt),
                () -> assertThat(racingGameResult.findFinalWinners()).isEqualTo(Arrays.asList("a", "c"))
        );
    }

}
