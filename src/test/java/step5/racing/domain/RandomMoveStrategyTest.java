package step5.racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomMoveStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 숫자가_0과_3사이의_값이라면_false를_반환한다(int number) {
        NumberGenerator numberGenerator = () -> number;
        MoveStrategy moveStrategy = new RandomMoveStrategy(numberGenerator);

        assertThat(moveStrategy.isMovable()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 숫자가_0과_4사이의_값이라면_true를_반환한다(int number) {
        NumberGenerator numberGenerator = () -> number;
        MoveStrategy moveStrategy = new RandomMoveStrategy(numberGenerator);

        assertThat(moveStrategy.isMovable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 숫자가_범위를_벗어난_값이라면_예외가_발생한다(int number) {
        NumberGenerator numberGenerator = () -> number;
        MoveStrategy moveStrategy = new RandomMoveStrategy(numberGenerator);

        assertThatThrownBy(moveStrategy::isMovable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
