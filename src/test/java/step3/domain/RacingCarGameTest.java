package step3.domain;

import step3.domain.strategy.RandomMovingStrategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame(new String[]{"BLACK", "WHITE", "BLUE"});
        for (int i = 0; i < 5; i++) {
            racingCarGame.play(new RandomMovingStrategy(3, 1));
        }
    }

    @Test
    @DisplayName("자동차 이름과 거리 값 테스트")
    void carNameAndDistanceTest() {
        for (Car car : racingCarGame.getCars()) {
            assertThat(car.getName().getName()).isNotEmpty();
            assertThat(car.getDistance().getMileage()).isGreaterThanOrEqualTo(0);
        }
    }

    @RepeatedTest(value = 5)
    @DisplayName("자동차 경주 우승자 이름 테스트")
    void winnerCarNamesTest() {
        assertThat(racingCarGame.getWinnerCarNames().size()).isBetween(1, 3);
    }
}
