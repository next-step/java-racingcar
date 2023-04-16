package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {

    private final String carName = "car1, car2, car3";
    private static final String DELIMITER = ",";
    private final int roundCount = 3;

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game(carName, roundCount);
    }

    @DisplayName("게임이 실행되면 게임 결과가 있어야 한다.")
    @Test
    void 게임결과_NULL_확인() {
        assertThat(game.play()).isNotNull();
    }

    @DisplayName("게임이 실행되면 라운드 만큼에 라운드 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드결과_값_확인() {
        assertThat(game.play().getRaceResults()).hasSize(roundCount);
    }

    @DisplayName("게임이 실행되면 라운드별 결과가 있어야 한다.")
    @Test
    void 게임결과_라운드별_결과_확인() {
        for (RaceResult raceResult : game.play().getRaceResults()) {
            assertThat(raceResult.getResult()).isNotEmpty();
        }
    }

    @DisplayName("게임이 실행되면 라운드별로 자동차 진행값이 존재해야한다.")
    @Test
    void 라운드결과값확인() {
        for (RaceResult raceResult : game.play().getRaceResults()) {
            assertThat(raceResult.getResult()).hasSize(carName.split(DELIMITER).length);
        }
    }

    @DisplayName("게임이 실행되면 우승자가 존재해야 한다.")
    @Test
    void 라운드우승자확인() {
        assertThat(game.play().getWinners()).isNotEmpty();
    }

}
