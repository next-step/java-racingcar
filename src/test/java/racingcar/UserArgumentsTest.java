package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserArgumentsTest {
    private UserArguments args;

    @BeforeEach
    void setUp() {
        this.args = UserArguments.createUserArgs(3, 5);
    }

    @Test
    void getArgsTest() {
        assertAll("Arguments",
                () -> assertEquals(3, this.args.getNumberOfCars()),
                () -> assertEquals(5, this.args.getNumberOfTrials())
        );
    }
}