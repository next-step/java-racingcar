package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("increase 메소드는 객체의 number 값 + 파라미터로 넘겨진 값을 합한 값을 가진 Position 객체를 반환한다.")
    void increase() {
        Position position = new Position(5);
        assertThat(position.increase(10)).isEqualTo(new Position(15));
    }

    @Test
    @DisplayName("isSameNumber 메소드는 주어진 값과 같은 값을 가지고 있는지 판단한다.")
    void isSameNumber() {
        assertThat(new Position(10).isSameNumber(10)).isTrue();
    }
}