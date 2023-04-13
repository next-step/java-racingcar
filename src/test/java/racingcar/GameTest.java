package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private final int carCount = 3;
    private final int roundCount = 3;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(carCount, roundCount);
    }

    @DisplayName("게임이 실행되면 게임 결과가 있어야 한다.")
    @Test
    void 게임결과_NULL_확인() {
        assertThat(game.play()).isNotNull();
    }

    @DisplayName("게임이 실행되면 라운드 만큼에 라운드 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드결과_값_확인() {
        assertThat(game.play().getResult()).hasSize(roundCount);
    }

    @DisplayName("게임이 실행되면 라운드별 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드별_결과_확인() {
        for (RoundResult roundResult : game.play().getResult()) {
            assertThat(roundResult.getResult()).isNotEmpty();
        }
    }

    @DisplayName("게임이 실행되면 라운드별로 자동차 진행값이 존재해야한다.")
    @Test
    void 라운드결과값확인() {
        for (RoundResult roundResult : game.play().getResult()) {
            assertThat(roundResult.getResult()).hasSize(carCount);
        }
    }

}
