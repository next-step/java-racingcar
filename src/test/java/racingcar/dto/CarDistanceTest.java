package racingcar.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racingcar.dto.ComparableConstants.*;

public class CarDistanceTest {
    private final int DISTANCE_ONE = 1;
    private final int DISTANCE_TWO = 2;
    private final int DISTANCE_THREE = 3;

    @Test
    void testCarDistanceGreaterThan() {
        CarDistance one = new CarDistance(DISTANCE_ONE);
        CarDistance two = new CarDistance(DISTANCE_TWO);

        assertThat(two.compareTo(one)).isEqualTo(GREATER_THAN);
    }

    @Test
    void testCarDistanceLesserThan() {
        CarDistance two = new CarDistance(DISTANCE_TWO);
        CarDistance three = new CarDistance(DISTANCE_THREE);

        assertThat(two.compareTo(three)).isEqualTo(LESSER_THAN);
    }

    @Test
    void testCarDistance() {
        CarDistance two = new CarDistance(DISTANCE_TWO);
        CarDistance twoTheSame = new CarDistance(DISTANCE_TWO);

        assertThat(two.compareTo(twoTheSame)).isEqualTo(EQUAL);
    }
}
