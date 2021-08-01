package carRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomMovigStrategyTest {

    RandomMovigStrategy randomMovigStrategy;

    @BeforeEach
    void setUp() {
        randomMovigStrategy = new RandomMovigStrategy();
    }

    @Test
    void isMove() {
        assertDoesNotThrow(() -> randomMovigStrategy.isMove());
    }
}