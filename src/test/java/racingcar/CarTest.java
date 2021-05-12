package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @DisplayName("자동차는 5자 이하의 이름을 가진다.")
    @Test
    public void name() {
    }

    @DisplayName("자동차 이름이 5자를 초과하는 경우 예외가 발생한다.")
    @Test
    public void invalidedName() {

    }

    @DisplayName("자동차의 거리를 알 수 있다.")
    @Test
    public void position() {

    }

    @DisplayName("자동차의 이름을 알 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"jason", "pobi"})
    public void name(final String name) {
    }
}
