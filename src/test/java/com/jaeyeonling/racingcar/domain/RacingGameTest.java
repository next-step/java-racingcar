package com.jaeyeonling.racingcar.domain;

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
    void completeGame() {
        // given
        final RacingGameOption gameOption = RacingGameOption.builder().build();
        final RacingGame game = new RacingGame(gameOption);

        // when
        while (!game.isComplete()) {
            game.move();
        }

        // then
        assertThat(game.isComplete()).isTrue();
    }
}
