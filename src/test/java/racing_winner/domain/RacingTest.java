package racing_winner.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @DisplayName("주어진 횟수 동안 경주-전진- 테스트")
    @ValueSource(ints = {3,4,5})
    void race(int round) {
        String[] cars = new String[]{"pobi", "crong"};
        Racing racing = new Racing(cars, round);

        for (int onRound = 0; onRound < round; onRound++) {
            racing.race(() -> true);
        }

        assertThat(racing.roundFinish()).isTrue();
    }
}