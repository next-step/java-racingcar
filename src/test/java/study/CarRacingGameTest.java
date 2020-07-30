package study;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

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
