package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarCount;
import racingcar.domain.TryCount;
import racingcar.exception.IllegalCountException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 시도횟수_입력값_음수_검증(int tryCountInput) {
        assertThatThrownBy(() -> {
            TryCount tryCount = new TryCount(tryCountInput);
        }).isInstanceOf(IllegalCountException.class);
    }
}
