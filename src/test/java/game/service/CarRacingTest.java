package game.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * 경주 기능
 * <pre>
 *     - 주어진 횟수 동안 n대의 자동차가 경주하도록 한다.
 * </pre>
 */
class CarRacingTest {
    private List<String> carNames = List.of("dummy");

    @Test
    @DisplayName("입력 옵션을 정상적(양수)으로 입력하면 자동차 경주가 정상적으로 수행됩니다.")
    void test1() {
        int racingRep = 5;
        CarRacing carRacing = new CarRacing(carNames, racingRep);
        assertThatNoException().isThrownBy(carRacing::start);
    }

    @Test
    @DisplayName("입력 옵션을 바정상적(음수 또는 0)으로 입력하면 자동차 경주가 수행되지 않습니다.")
    void test2() {
        int racingRep = -1;
        assertThatThrownBy(() -> new CarRacing(carNames, racingRep))
                .isInstanceOf(IllegalArgumentException.class);
    }
}