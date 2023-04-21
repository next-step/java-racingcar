package study.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.racingcar.domain.Car;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameInputs;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 횟수만큼 움직였다면 게임은 종료된다.")
    @ParameterizedTest
    @ValueSource(ints = {5,3,4})
    public void RacingGame_isOver_종료테스트(int games) {

        RacingGame racingGame = new RacingGame(new RacingGameInputs(games, "pobbi,crong,honux"));

        for(int i = 0; i < games; i++){
            racingGame.nextLap();
        }

        assertThat(racingGame.isOver()).isTrue();
    }

    @DisplayName("게임 횟수만큼 움직이고 현재 위치가 포함되는지 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {5,3,4})
    public void RacingGame_move(int games) {

        RacingGame racingGame = new RacingGame(new RacingGameInputs(games, "pobbi,crong,honux"));

        while (!racingGame.isOver()) {
            racingGame.moveCar();
            racingGame.nextLap();
        }

        assertThat(racingGame.getCars())
                .extracting(Car::currentPosition)
                .hasSizeBetween(0, games);
    }
}
