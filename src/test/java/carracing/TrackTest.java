package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TrackTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100, 999})
    @DisplayName("Track forward() 테스트")
    void trackForward(int round) {
        List<CarName> carNames = generateCarNames(100);
        Track track = new Track(carNames);

        List<Round> rounds = new LinkedList<>();
        for (int i = 0; i < round; i++) {
            Round currentRound = track.forward();
            rounds.add(currentRound);
        }

        Round lastRound = rounds.get(rounds.size() - 1);

        Map<CarName, Integer> steps = lastRound.getSteps();
        steps.forEach((carName, step) -> {
            assertThat(step).isGreaterThanOrEqualTo(0);
            assertThat(step).isLessThanOrEqualTo(round);
        });
    }

    private List<CarName> generateCarNames(int number) {
        List<CarName> carNames = new ArrayList<>(number);
        for (int i = 0; i < 100; i++) {
            carNames.add(new CarName(String.format("car%d", i)));
        }
        return carNames;
    }
}