package step03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarRoundTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("주어진 totalTryCount 만큼 경기를 반복하는지 테스트")
    void isFinishRound(int totalCount) {
        RacingCarRound racingCarRound = new RacingCarRound(totalCount);
        for (int i = 0; i < totalCount; i++) {
            assertThat(racingCarRound.isFinishRound()).isEqualTo(false);
        }
        assertThat(racingCarRound.isFinishRound()).isEqualTo(true);
    }
}
