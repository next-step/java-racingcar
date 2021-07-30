package racingcargame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarGameTest {
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = new RacingCarGame(3,1);
    }

    @DisplayName("입력한 자동차 수 만큼 자동차 객체를 생성한다.")
    @Test
    void createCar() {
        assertEquals(racingCarGame.createCars(3).size(), 3);
    }
}
