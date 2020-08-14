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
        Move movement = new NeverMove();
        List<Snapshot> expected = new ArrayList<>();
        for (int i = 0; i < numberOfCars * numberOfTrials; i++) {
            expected.add(new Snapshot(0));
        }

        // when
        List<Snapshot> result = new RacingGame(numberOfCars, numberOfTrials).run(movement);

        // then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("모든 차가 항상 이동한 경우 테스트")
    void runAlways() {
        // given
        Move movement = new AlwaysMove();
        List<Snapshot> expected = Arrays.asList(
                new Snapshot(1), new Snapshot(1), new Snapshot(1),
                new Snapshot(2), new Snapshot(2), new Snapshot(2),
                new Snapshot(3), new Snapshot(3), new Snapshot(3)
        );

        // when
        List<Snapshot> actual = new RacingGame(numberOfCars, numberOfTrials).run(movement);

        // then
        assertEquals(expected, actual);
    }
}
