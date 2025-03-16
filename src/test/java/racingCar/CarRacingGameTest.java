package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CarRacingGameTest {
    private CarRacingGame carRacingGame;
    private RacingCar[] cars;

    @BeforeEach
    void setUp() {
        InputView mockInputView = mock(InputView.class);
        ResultView mockResultView = mock(ResultView.class);
        NumberVerifier numberVerifier = mock(NumberVerifier.class);
        carRacingGame = new CarRacingGame(mockInputView, mockResultView, numberVerifier);
        cars = new RacingCar[3];
    }

    @Test
    void testValidateNames_validNames() {
        int TEST_COUNT = 3;
        assertDoesNotThrow(() -> carRacingGame.validateNum(TEST_COUNT));
    }

    @Test
    void testValidateNames_invalidNames() {
        int TEST_COUNT = 3;
        assertThrows(NumberFormatException.class, () -> carRacingGame.validateNum(TEST_COUNT));
    }

    @Test
    void testCreateRacingCars() {
        int TEST_COUNT = 3;
        RacingCar[] createdCars = carRacingGame.createRacingCars(TEST_COUNT);
        assertEquals(3, createdCars.length);
    }
}
