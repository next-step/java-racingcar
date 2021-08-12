package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest {
    @DisplayName("이동거리가 1 증가한다")
    @Test
    void increaseDistance() {
        Distance distance = new Distance(0);
        int expected = 1;
        int actual = distance.increase();

        assertEquals(expected, actual);
    }
}