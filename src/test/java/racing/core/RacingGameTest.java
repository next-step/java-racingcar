package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private static int numberOfCars = 3;
    private static int numberOfTrials = 3;

    @Test
    @DisplayName("모든 차가 전혀 이동하지 경우 테스트")
    void runNever() {
        // given
        List<TrackInfo> expected = new ArrayList<>();
        for (int i = 0; i < numberOfCars * numberOfTrials; i++) {
            expected.add(new TrackInfo(0));
        }

        // when
        List<TrackInfo> result = new RacingGame(numberOfCars, numberOfTrials).run(() -> false);

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("모든 차가 항상 이동한 경우 테스트")
    void runAlways() {
        // given
        List<TrackInfo> expected = Arrays.asList(
                new TrackInfo(1), new TrackInfo(1), new TrackInfo(1),
                new TrackInfo(2), new TrackInfo(2), new TrackInfo(2),
                new TrackInfo(3), new TrackInfo(3), new TrackInfo(3)
        );

        // when
        List<TrackInfo> actual = new RacingGame(numberOfCars, numberOfTrials).run(() -> true);

        // then
        assertEquals(expected, actual);
    }
}
