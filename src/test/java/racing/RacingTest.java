package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SuppressWarnings("NonAsciiCharacters")
public class RacingTest {

    @Test
    void 자동차_경주는_이동횟수만큼_진행() {
        String names = "one,two,three";
        int totalRound = 5;
        Racing racing = new Racing(names, totalRound, new RandomNumberGenerator());
        for (int idx = 0; idx < totalRound; idx++) {
            assertThat(racing.isEnd()).isEqualTo(false);
            racing.play();
        }
        assertThat(racing.isEnd()).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void 이동횟수_10이하의_자연수가_아니라면_오류_발생(int round) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Racing("one,two", round, new RandomNumberGenerator()));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void 이동횟수_10이하의_자연수라면_오류_미발생(int round) {
        assertDoesNotThrow(() -> new Racing("one,two", round, new RandomNumberGenerator()));
    }

}
