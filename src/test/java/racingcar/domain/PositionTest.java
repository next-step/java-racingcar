package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("포지션을 생성하면 해당 포지션을 가지고 있습니다.")
    public void getPositionTest(int position) {
        Position positionInstance = Position.valueOf(position);
        assertThat(positionInstance.value()).isEqualTo(position);
    }

    @Test
    @DisplayName("음수 포지션을 생성하려고 하면 에러가 발생합니다")
    public void NegativePositionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Position.valueOf(-1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("move하면 포지션이 1 증가한다.")
    public void moveTest(int position) {
        Position positionInstance = Position.valueOf(position);
        Position newPositionInstance = positionInstance.move();
        assertThat(newPositionInstance.value()).isEqualTo(position + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("같은 position 을 가지면 equals()가 true다")
    public void equalsTest(int position) {
        Position positionInstance1 = Position.valueOf(position);
        Position positionInstance2 = Position.valueOf(position);
        assertThat(positionInstance1).isEqualTo(positionInstance2);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("같은 position 을 가지면 같은 hashCode()가 true다")
    public void hashCodeTest(int position) {
        Position positionInstance1 = Position.valueOf(position);
        Position positionInstance2 = Position.valueOf(position);
        assertThat(positionInstance1.hashCode()).isEqualTo(positionInstance2.hashCode());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    @DisplayName("큰 position 을 가진 Position이 더 크다")
    public void compareTest(int position) {
        Position positionInstanceWithSmallPosition = Position.valueOf(position);
        Position positionInstanceWithBiggerPosition = Position.valueOf(position + 1);
        assertThat(positionInstanceWithBiggerPosition).isGreaterThan(positionInstanceWithSmallPosition);
    }
}
