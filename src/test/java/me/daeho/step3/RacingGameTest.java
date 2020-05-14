package me.daeho.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 테스트")
class RacingGameTest {
    private static final int DEFAULT_CAR_COUNT = 3;
    private static final int DEFAULT_TIME = 5;

    @DisplayName("남은 횟수 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:true", "0:false"}, delimiter = ':')
    public void initAndHasNextTest(int time, boolean expectedValue) {
        RacingGame racingGame = RacingGame.init(time, DEFAULT_CAR_COUNT);
        assertThat(racingGame.hasNext()).isEqualTo(expectedValue);
    }

    @DisplayName("남은 횟수 차감 테스트")
    @Test
    public void subtractTimeTest() {
        RacingGame racingGame = RacingGame.init(1, DEFAULT_CAR_COUNT);

        assertThat(racingGame.hasNext()).isTrue();

        racingGame.next();

        assertThat(racingGame.hasNext()).isFalse();
    }

    @DisplayName("설정된 자동차 대수와 결과 값의 자동차 대수 비교 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void carCountCompareTest(int carCount) {
        RacingGame racingGame = RacingGame.init(DEFAULT_TIME, carCount);

        assertThat(racingGame.move().length).isEqualTo(carCount);
    }
}
