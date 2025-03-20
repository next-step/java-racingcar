package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarRacingGameTest {
    private CarRacingGame carRacingGame;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        NumberVerifier numberVerifier = new NumberVerifier();
        carRacingGame = new CarRacingGame(inputView, resultView, numberVerifier);
    }

    @Test
    void testCreateRacingCars() {
        int TEST_COUNT = 3;
        RacingCar[] createdCars = carRacingGame.createRacingCars(TEST_COUNT);
        assertEquals(3, createdCars.length);
    }
}
