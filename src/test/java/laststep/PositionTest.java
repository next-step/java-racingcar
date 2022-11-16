package laststep;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import laststep.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositionTest {

    @ParameterizedTest
    @DisplayName("위치 생성 시 예외 발생")
    @ValueSource(ints = {-1,0})
    void validatePosition(int position) {
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("위치가 1미만일 수 없어요");
    }

    @Test
    @DisplayName("위치 생성 시 예외 발생")
    void successPosition() {
        Position actual = new Position(1);
        assertThat(actual).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("위치 생성 확인")
    void position() {
        Position actual = new Position(3);
        Position expected = new Position(3);

        assertThat(actual).isEqualTo(expected);
    }
}
