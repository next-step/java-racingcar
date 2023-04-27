package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarRacingGameTest {

    @Test
    void 자동차_두대_이상_경주생성_성공() {
        assertThatNoException().isThrownBy(() -> new CarRacingGame("0giri,pobi,tdd"));
    }

    @Test
    void 자동차_두대_미만_경주생성_예외() {
        assertThatThrownBy(() -> new CarRacingGame("0giri")).isInstanceOf(IllegalArgumentException.class);
    }
}
