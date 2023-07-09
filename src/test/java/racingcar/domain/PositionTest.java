package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

    @Test
    @DisplayName("같은 값을 가지는 포지션을 같은 객체이다.")
    public void positionTest_samePosition() {
        Position position1 = new Position(1);
        Position position2 = new Position(1);

        assertThat(position1.equals(position2)).isTrue();
    }

    @Test
    @DisplayName("다른 값을 가지는 포지션을 같은 객체이다.")
    public void positionTest_differentPosition() {
        Position position1 = new Position(1);
        Position position2 = new Position(2);

        assertThat(position1.equals(position2)).isFalse();
    }
}
