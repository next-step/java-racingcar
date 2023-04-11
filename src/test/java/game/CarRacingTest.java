package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 경주 기능
 * <pre>
 *     - 주어진 횟수 동안 n대의 자동차가 경주하도록 한다.
 * </pre>
 */
class CarRacingTest {

    @Test
    @DisplayName("입력 옵션을 기준으로 자동차 경주가 정상적으로 수행됩니다.")
    void test() {
        int carCount = 3, racingRep = 5;
        CarRacing carRacing = new CarRacing(new RacingOptions(carCount, racingRep));
        Assertions.assertThatNoException().isThrownBy(carRacing::start);
    }
}