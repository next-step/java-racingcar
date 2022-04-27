package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @DisplayName("포지션 생성 테스트 - NoArg")
    @Test
    void createPositionNoArg() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position());
    }

    @DisplayName("포지션 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 100})
    void createPositionArg(int newPosition) {
        Position position = new Position(newPosition);
        assertThat(position).isEqualTo(new Position(newPosition));
    }

    @DisplayName("포지션 생성 테스트 - 실패 케이스")
    @Test
    void createPositionFail() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("포지션 이동 테스트")
    @Test
    void goForwardTest() {
        Position position = new Position();
        position.goForward();
        assertThat(position).isEqualTo(new Position(1));
    }
}