package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameInputsTest {
    private GameInputs args;
    private int numberOfCars;
    private int numberOfTrials;

    @BeforeEach
    void setUp() {
        numberOfCars = 3;
        numberOfTrials = 5;
        this.args = GameInputs.createGameInputs(numberOfCars, numberOfTrials);
    }

    @Test
    void getArgsTest() {
        assertAll("Arguments",
                () -> assertEquals(numberOfCars, this.args.getNumberOfCars()),
                () -> assertEquals(numberOfTrials, this.args.getNumberOfTrials())
        );
    }
}