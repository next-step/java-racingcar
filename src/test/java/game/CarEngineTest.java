package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 자동차 엔진기능
 * <pre>
 *     - 랜덤하게 전진 여부 결정한다.
 *     - 결정된 전진 여부를 반환한다.
 * </pre>
 */
class CarEngineTest {

    @Test
    @DisplayName("자동차 엔진은 랜덤하게 전진여부를 결정하여 결과(0~9)를 반환합니다.")
    void test() {
        int engineValue = CarEngine.turn();
        assertThat(validRange(engineValue)).isTrue();
    }

    private boolean validRange(int engineValue) {
        return 0 <= engineValue && engineValue <= 9;
    }
}