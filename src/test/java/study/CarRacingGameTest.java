package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 경주 게임 테스트")
class CarRacingGameTest {

    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        carRacingGame = new CarRacingGame();
    }

    @Test
    @DisplayName("자동차 경주를 시작한다.")
    void addCar() {
        carRacingGame.start();
    }

}
