package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingTest {
    String[] namesOfCars = {"가나다라마", "바사아", "자차", "카", "타파하"};

    @DisplayName("주어진 조건으로 레이싱게임을 생성한다.")
    @Test
    void withCondition() {
        int numberOfTurns = 5;
        Racing racing = Racing.withCondition(namesOfCars, numberOfTurns);

        assertEquals(namesOfCars.length, racing.getCars().size());
        assertEquals(numberOfTurns, racing.getNumberOfTurns());
    }

    @DisplayName("주어진 횟수만큼 레이싱을 진행할 수 있다.")
    @Test
    void race() {
        int numberOfTurns = 1;
        Racing racing = Racing.withCondition(namesOfCars, numberOfTurns);

        while (numberOfTurns > 0) {
            assertFalse(racing.hasRaceEnd());
            racing.race();
            numberOfTurns--;
        }
        assertTrue(racing.hasRaceEnd());
    }
}
