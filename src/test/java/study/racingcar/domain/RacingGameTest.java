package study.racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.car.NewEngine;
import study.racingcar.domain.car.CarSnapshot;
import study.racingcar.domain.racingcars.RacingCarsSnapshot;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RacingGameTest {

    @Test
    @DisplayName("게임을 진행하고 결과를 검증한다")
    void test_startGame() {

        // Given
        GameConfiguration gameConfiguration
                = new GameConfiguration("a,b,c", 5, new NewEngine());
        RacingGame racingGame = new RacingGame(gameConfiguration);

        // When
        RacingGameResult racingGameResult = racingGame.startGame();

        // Then
        List<RacingCarsSnapshot> gameProgressSnapshots = racingGameResult.getGameProgressSnapshots();
        assertEquals(gameProgressSnapshots.size(), 5);

        List<CarSnapshot> winners = racingGameResult.getWinners();
        assertTrue(winners.size() >= 1);

    }
}