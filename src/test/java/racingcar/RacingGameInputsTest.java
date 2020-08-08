package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameInputsTest {
    private GameInputs args;
    private String[] nameOfCars;
    private int numberOfTrials;

    @BeforeEach
    void setUp() {
        nameOfCars = new String[] {"pobi", "eesuel", "nextStep"};
        numberOfTrials = 5;
        this.args = GameInputs.createGameInputs(nameOfCars, numberOfTrials);
    }

    @Test
    void getArgsTest() {
        assertAll("Arguments",
                () -> assertEquals(nameOfCars, this.args.getNameOfCars()),
                () -> assertEquals(numberOfTrials, this.args.getNumberOfTrials())
        );
    }
}