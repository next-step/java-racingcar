package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Position;
import racingcar.exception.NotPositivePositionException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("포지션을 생성한다.")
    public void positionTest_createPosition(int value) {
        assertDoesNotThrow(() -> new Position(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("0이하의 값은 예외를 던진다.")
    public void positionTest_createPositivePosition(int value) {
        assertThatThrownBy(() -> new Position(value))
                .isInstanceOf(NotPositivePositionException.class);
    }

    @Test
    @DisplayName("자동차 이동 시 포지션의 값이 1 증가한다.")
    public void positionTest_movePosition() {
        int beforeValue = 1;
        Position position = new Position(beforeValue);

        Position increasePosition = position.increaseValue();

        assertThat(increasePosition.getValue()).isEqualTo(beforeValue + 1);
    }
}
