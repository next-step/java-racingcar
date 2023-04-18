package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 횟수만큼 움직였다면 게임은 종료된다.(False 반환)")
    @ParameterizedTest
    @CsvSource(value = {"5:6", "3:4", "1:2"}, delimiter = ':')
    public void RacingGame_isOver_종료테스트(int games, int laps) {

        RacingGame racingGame = new RacingGame(new RacingGameInputs(games, "pobbi,crong,honux"));

        for(int i = 0; i < games; i++){
            racingGame.nextLap();
        }

        assertThat(racingGame.isOver(laps)).isFalse();
    }

    @DisplayName("게임 횟수만큼 이전 값이면 게임은 종료되지 않는다.(True 반환)")
    @ParameterizedTest
    @CsvSource(value = {"5:3", "3:1", "1:0"}, delimiter = ':')
    public void RacingGame_isOver_지속테스트(int games, int laps) {

        RacingGame racingGame = new RacingGame(new RacingGameInputs(games, "pobbi,crong,honux"));

        for(int i = 0; i < games; i++){
            racingGame.nextLap();
        }

        assertThat(racingGame.isOver(laps)).isTrue();
    }
}
