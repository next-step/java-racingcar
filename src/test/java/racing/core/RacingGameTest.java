package racing.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.core.domain.RacingGame;
import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;

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
        List<Trial> expected = Arrays.asList(
                new Trial(Arrays.asList(new TrackInfo(0), new TrackInfo(0), new TrackInfo(0))),
                new Trial(Arrays.asList(new TrackInfo(0), new TrackInfo(0), new TrackInfo(0))),
                new Trial(Arrays.asList(new TrackInfo(0), new TrackInfo(0), new TrackInfo(0)))
        );

        // when
        List<Trial> actual = new RacingGame(expected.get(0).getNumberOfTrack(), expected.size()).run(() -> false);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 차가 항상 이동한 경우 테스트")
    void runAlways() {
        // given
        List<Trial> expected = Arrays.asList(
                new Trial(Arrays.asList(new TrackInfo(1), new TrackInfo(1), new TrackInfo(1))),
                new Trial(Arrays.asList(new TrackInfo(2), new TrackInfo(2), new TrackInfo(2))),
                new Trial(Arrays.asList(new TrackInfo(3), new TrackInfo(3), new TrackInfo(3)))
        );

        // when
        List<Trial> actual = new RacingGame(expected.get(0).getNumberOfTrack(), expected.size()).run(() -> true);

        // then
        assertEquals(expected, actual);
    }
}
