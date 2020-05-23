import mission1.racing.Movement;
import mission1.racing.RacingRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingTest {
    RacingRandom random = new RacingRandom();
    Movement movement = new Movement();

    @DisplayName("랜덤의 범위가 0~9인지 확인")
    @Test
    void testRandomRange() {
        int randomResult = random.random();
        assertTrue(randomResult >= 0 && randomResult < 10);
    }

    @DisplayName("이동 조건이 맞는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1 : 0", "3 : 0", "4 : 1", "5 : 1", "9 : 1"}, delimiter = ':')
    void testMoveCondition(int num, int expected) {
        assertEquals(movement.moveCondition(num), expected);
    }

}
