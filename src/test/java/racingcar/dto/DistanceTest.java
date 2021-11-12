package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.dto.ComparableConstants.*;

public class DistanceTest {
    private final int DISTANCE_ONE = 1;
    private final int DISTANCE_TWO = 2;
    private final int DISTANCE_THREE = 3;

    @Test
    void testCarDistanceGreaterThan() {
        Distance one = new Distance(DISTANCE_ONE);
        Distance two = new Distance(DISTANCE_TWO);

        assertThat(two.compareTo(one)).isEqualTo(GREATER_THAN);
    }

    @Test
    void testCarDistanceLesserThan() {
        Distance two = new Distance(DISTANCE_TWO);
        Distance three = new Distance(DISTANCE_THREE);

        assertThat(two.compareTo(three)).isEqualTo(LESSER_THAN);
    }

    @Test
    void testCarDistance() {
        Distance two = new Distance(DISTANCE_TWO);
        Distance twoTheSame = new Distance(DISTANCE_TWO);

        assertThat(two.compareTo(twoTheSame)).isEqualTo(EQUAL);
    }

    @Test
    void testIncrement() {
        Distance one = new Distance(DISTANCE_ONE);
        Distance two = new Distance(DISTANCE_TWO);
        one.increment();

        assertThat(one.compareTo(two)).isEqualTo(EQUAL);
    }
}
