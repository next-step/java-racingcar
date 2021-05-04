package domain.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest {

    @Test
    @DisplayName("5번 이동한 거리 확인")
    void check_distance_moved_5_times() {
        //given
        Distance distance = new Distance();

        //when
        for (int i = 0; i < 5; i++) {
            distance.increaseDistance();
        }
        String printMessage = distance.getDistancePrintMessage();

        //then
        assertEquals(printMessage, ("-----"));
    }
}
