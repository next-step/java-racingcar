package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingGameArgumentsTest {
    private UserArguments args;
    private int numberOfCars;
    private int numberfOfTrials;

    @BeforeEach
    void setUp() {
        numberOfCars = 3;
        numberfOfTrials = 5;
        this.args = UserArguments.createUserArgs(numberOfCars, numberfOfTrials);
    }

    @Test
    void getArgsTest() {
        assertAll("Arguments",
                () -> assertEquals(numberOfCars, this.args.getNumberOfCars()),
                () -> assertEquals(numberfOfTrials, this.args.getNumberOfTrials())
        );
    }
}