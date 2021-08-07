package com.racingcar.game;

import com.racingcar.view.model.GameInputDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RacingGameTest {
    @DisplayName("RacingGame 게임 종료 이후 플레이 요청 테스트")
    @Test
    public void playOneRoundAfterFinish() {
        //given
        String names = "john,cart,mon,see";
        int gameRound = 1;
        GameInputDto input = new GameInputDto(names, gameRound);

        //when
        RacingGame racingGame = GameMaker.make(input);
        racingGame.playOneRound();

        //then
        assertThatIllegalStateException().isThrownBy(() -> {
            racingGame.playOneRound();
        });
    }

    @DisplayName("RacingGame 종료 전 우승자 요청 테스트")
    @Test
    public void getWinnersBeforeFinish() {
        //given
        String names = "john,cart,mon,see";
        int gameRound = 1;
        GameInputDto input = new GameInputDto(names, gameRound);

        //when
        RacingGame racingGame = GameMaker.make(input);

        //then
        assertThatIllegalStateException().isThrownBy(() -> {
            racingGame.getWinners();
        });
    }

    @DisplayName("Game 종료 여부 확인 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "4,4", "5,5"})
    public void isGameFinished(int gameRound, int plays) {
        //given
        String names = "john,cart,mon,see";
        GameInputDto input = new GameInputDto(names, gameRound);

        //when
        RacingGame racingGame = GameMaker.make(input);
        for (int i = 0; i < plays; i++) {
            racingGame.playOneRound();
        }

        //then
        assertThat(racingGame.isGameFinished()).isTrue();
    }

    @DisplayName("Game 종료가 안됬는 지 여부 확인 테스트")
    @ParameterizedTest
    @CsvSource({"3,2", "4,3", "5,4"})
    public void isGameNotFinished(int gameRound, int plays) {
        //given
        String names = "john,cart,mon,see";
        GameInputDto input = new GameInputDto(names, gameRound);

        //when
        RacingGame racingGame = GameMaker.make(input);
        for (int i = 0; i < plays; i++) {
            racingGame.playOneRound();
        }

        //then
        assertThat(racingGame.isNotGameFinished()).isTrue();
    }
}
