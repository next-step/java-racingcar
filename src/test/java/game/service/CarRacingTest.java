package game.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;

/**
 * 경주 기능
 * <pre>
 *     - 주어진 횟수 동안 n대의 자동차가 경주하도록 한다.
 * </pre>
 */
class CarRacingTest {
    
    private final List<String> carNames = List.of("dummy");

    @Test
    @DisplayName("입력 옵션을 정상적으로 입력하면 자동차 경주가 정상적으로 수행됩니다.")
    void test1() {
        CarRacing carRacing = new CarRacing(carNames);
        assertThatNoException().isThrownBy(carRacing::start);
    }

}