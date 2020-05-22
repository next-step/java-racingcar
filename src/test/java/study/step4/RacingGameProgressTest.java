package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameProgressTest {

    @ParameterizedTest
    @DisplayName("게임 구현에 대한(결과값) 테스트")
    @ValueSource(ints = {10, 25, 30})
    void gameStartTest(int tryNumber){
        String carNames ="차1,차2,차3";
        RacingGame racingGame = new RacingGame(carNames,tryNumber);
        RacingGameProgress racingGameProgress = new RacingGameProgress(racingGame);
        List<Round> rounds = racingGameProgress.gameStart(new RandomCarMoveCondition());

        assertThat(rounds.size()).isEqualTo(tryNumber);
    }
}
