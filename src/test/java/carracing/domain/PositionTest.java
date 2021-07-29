package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @DisplayName("Position 객체는 음수 값을 가질 수 없다.")
    @Test
    public void invalidPositionTest() {
        int negativeValue = -1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Position.of(negativeValue))
                .withMessageContaining("유효하지 않은 위치 값입니다.");
    }

    @ParameterizedTest(name = "Position 객체 생성 성공 테스트")
    @ValueSource(ints = {0, 1})
    public void positionCreateTest(int validPositionValue) {
        assertThat(Position.of(validPositionValue))
                .isExactlyInstanceOf(Position.class)
                .matches(position -> position.isAt(validPositionValue));
    }

    @ParameterizedTest(name = "위치(value) 만큼 '-' 를 반복하여 그린다.")
    @ValueSource(ints = {0, 1, 5})
    public void positionRenderTest(int positionValue) {
        Renderer position = Position.of(positionValue);
        assertThat(position.render())
                .isEqualTo(String.join("", Collections.nCopies(positionValue, "-")));
    }

}