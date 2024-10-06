package racingGame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 9, 10, 100})
    @DisplayName("유효한 값이면 정상적으로 생성된다.")
    void create(int validPosition) {
        Position position = new Position(validPosition);

        assertThat(position).isEqualTo(new Position(validPosition));
    }

    @DisplayName("위치값이 음수이면 예외가 발생한다.")
    @Test
    void throwExceptionForMinus() {
        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move 함수가 실행되면 position 값이 1 증가한다.")
    @Test
    void move() {
        Position position = new Position(3);

        position.move();

        assertThat(position).isEqualTo(new Position(4));
    }
}

