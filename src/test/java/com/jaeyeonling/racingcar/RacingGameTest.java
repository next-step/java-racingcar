package com.jaeyeonling.racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("RacingGame 객체 생성")
    @Test
    void newRacingGame() {
        assertThat(new RacingGame(RacingGameOption.builder().build())).isNotNull();
    }

    @DisplayName("RacingGame 게임 완료 테스트")
    @Test
    void playGame() {
        final RacingGameOption gameOption = RacingGameOption.builder().build();
        final RacingGame game = new RacingGame(gameOption);

        while (!game.isComplete()) {
            game.move();
        }

        assertThat(game.isComplete()).isTrue();
    }
}
