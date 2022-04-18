package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Position;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @DisplayName("position 객체 생성 동등성 테스트")
    @Test
    void equalsTest() {
        assertThat(new Position()).isEqualTo(new Position(0));
    }

    @DisplayName("primitive 값으로 가져오는 getCurrentPosition 테스트")
    @Test
    void getPrimitiveTest() {
        assertThat(new Position(1).getCurrentPosition()).isEqualTo(1);
    }

    @DisplayName("add 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0, 1, 1", "1, 2, 3"})
    void addTest(int init, int runStep, int expected) {
        Position position = new Position(init);
        position.add(runStep);
        assertThat(position.getCurrentPosition()).isEqualTo(expected);
    }
}