package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.RacingGame;
import racingcar.domain.Round;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private final String CAR_NAMES = "pobi,crong,honux";
    private final int TIME = 3;
    private final int COUNT = 3;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(CAR_NAMES, new Round(TIME));
    }

    @DisplayName("count 만큼 자동차 객체 생성을 성공한다.")
    @Test
    void ready() {
        assertThat(racingGame.getCars().toList()).hasSize(COUNT);
    }

    @DisplayName("경주 게임 종료를 성공한다.")
    @Test
    void isGameOver() {
        // when
        while(!racingGame.isGameOver()) {
            racingGame.play();
        }

        // then
        assertThat(racingGame.isGameOver()).isTrue();
    }
}