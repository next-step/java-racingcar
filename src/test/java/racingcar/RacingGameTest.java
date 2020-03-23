package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {
    private RacingGame racingGame;
    private final int TIME = 3;
    private final int COUNT = 5;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, COUNT);
    }

    @DisplayName("count 만큼 자동차 객체 생성을 성공한다.")
    @Test
    void ready() {
        assertThat(racingGame.getCars()).hasSize(COUNT);
    }
}