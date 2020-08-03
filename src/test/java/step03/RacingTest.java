package step03;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 7:39 오후
 */
class RacingTest {

    @Test
    public void raceTest() {
        Racing racing = new Racing();
        Map<Car, Integer> race1 = racing.race(3, 5);
        Map<Car, Integer> race2 = racing.race(4, 5);

        assertEquals(race1.size(), 3);
        assertEquals(race2.size(), 4);
    }
}