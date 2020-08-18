package racing.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.core.domain.RacingGame;
import racing.core.dto.TrackInfo;
import racing.core.dto.Trial;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingGameTest {

    private String[] namesOfCars = new String[] {"test1", "test2", "test3"};
    private int numberOfTrials = 3;

    @Test
    @DisplayName("모든 차가 전혀 이동하지 경우 테스트")
    void runNever() {
        // given
        List<Trial> expected = new ArrayList<>(numberOfTrials);
        for (int i = 0; i < numberOfTrials; i++) {
            expected.add(new Trial(getTracksNeverMoved()));
        }

        // when
        List<Trial> actual = new RacingGame(namesOfCars, expected.size()).run(() -> false);

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 차가 항상 이동한 경우 테스트")
    void runAlways() {
        // given
        List<Trial> expected = new ArrayList<>(numberOfTrials);
        for (int i = 0; i < numberOfTrials; i++) {
            expected.add(new Trial(getTracksAlwaysMoved(i + 1)));
        }

        // when
        List<Trial> actual = new RacingGame(namesOfCars, expected.size()).run(() -> true);

        // then
        assertEquals(expected, actual);
    }

    private List<TrackInfo> getTracksNeverMoved() {
        List<TrackInfo> tracks = new ArrayList<>(namesOfCars.length);
        for (int i = 0; i < namesOfCars.length; i++) {
            tracks.add(new TrackInfo(namesOfCars[i], 0));
        }
        return tracks;
    }

    private List<TrackInfo> getTracksAlwaysMoved(int position) {
        List<TrackInfo> tracks = new ArrayList<>(namesOfCars.length);
        for (int i = 0; i < namesOfCars.length; i++) {
            tracks.add(new TrackInfo(namesOfCars[i], position));
        }
        return tracks;
    }
}
