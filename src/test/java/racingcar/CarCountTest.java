package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarCount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarCountTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void 자동차수_입력값_음수_검증(int carCountInput) {
        assertThatThrownBy(() -> {
            CarCount carCount = new CarCount(carCountInput);
        }).isInstanceOf(Exception.class);
    }
}
