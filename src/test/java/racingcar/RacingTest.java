package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {

    @DisplayName("주어진 조건으로 레이싱게임을 생성한다.")
    @Test
    void withCondition() {
        int numberOfCars = 3;
        int numberOfTurns = 5;
        Racing racing = Racing.withCondition(numberOfCars, numberOfTurns);

        assertEquals(numberOfCars, racing.getCars().size());
        assertEquals(numberOfTurns, racing.getNumberOfTurns());
    }

    @DisplayName("주어진 횟수만큼 레이싱을 진행할 수 있다.")
    @Test
    void race() {
        int numberOfCars = 3;
        int numberOfTurns = 1;
        Racing racing = Racing.withCondition(numberOfCars, numberOfTurns);

        while (numberOfTurns > 0) {
            assertFalse(racing.hasRaceEnd());
            racing.race();
            numberOfTurns--;
        }
        assertTrue(racing.hasRaceEnd());
    }
}