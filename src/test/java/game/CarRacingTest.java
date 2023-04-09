package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * 경주 기능
 * <pre>
 *     - 주어진 횟수 동안 n대의 자동차가 경주하도록 한다.
 * </pre>
 */
class CarRacingTest {

    @Test
    @DisplayName("입력 옵션을 기준으로 자동차 대수와 경기수 만큼 경주를 진행합니다.")
    void test() {
        int carCount = 3, racingRep = 5;
        CarRacing carRacing = new CarRacing(new RacingOptions(carCount, racingRep));
        carRacing.start();
        assertAll(
                () -> assertThat(carRacing.carCount()).isSameAs(carCount),
                () -> assertThat(carRacing.racingCount()).isSameAs(racingRep)
        );
    }
}