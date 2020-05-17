package race;

import static org.assertj.core.api.Java6Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private static final int DEFAULT_TIME = 3;

    @DisplayName("자동차 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void initRacingCarTest(int racingCarCount) {
        RacingGame racingGame = RacingGame.of(racingCarCount, DEFAULT_TIME);
        racingGame.readyRacingCars(racingCarCount);
        assertThat(racingGame.start().size()).isEqualTo(racingCarCount);
    }
}