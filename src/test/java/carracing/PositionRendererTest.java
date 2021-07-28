package carracing;

import carracing.domain.Position;
import carracing.view.PositionRenderer;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionRendererTest {

    @ParameterizedTest(name = "null 객체를 랜더링 할 수 없다.")
    @NullSource
    public void notNullTest(Position nullPosition) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PositionRenderer.of(nullPosition));
    }

    @ParameterizedTest(name = "Position 객체의 value 만큼 '-' 를 반복하여 그린다.")
    @ValueSource(ints = {0, 1, 5})
    public void positionRenderTest(int positionValue) {
        PositionRenderer renderer = PositionRenderer.of(Position.of(positionValue));
        assertThat(renderer.render())
                .isEqualTo(String.join("", Collections.nCopies(positionValue, "-")));
    }

}