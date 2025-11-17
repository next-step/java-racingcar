package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomMoveStrategyTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    void 숫자가_0과3사이면_전진하지_않는다(int number) {
        NumberGenerator generator = () -> number;
        MoveStrategy strategy = new RandomMoveStrategy(generator);

        assertThat(strategy.isMovable()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    void 숫자가_4와9사이면_전진한다(int number) {
        NumberGenerator generator = () -> number;
        MoveStrategy strategy = new RandomMoveStrategy(generator);

        assertThat(strategy.isMovable()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void 숫자가_범위를_벗어나면_예외가_발생한다(int number) {
        NumberGenerator generator = () -> number;
        MoveStrategy strategy = new RandomMoveStrategy(generator);

        assertThatThrownBy(strategy::isMovable)
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("랜덤 값이 0과 9 사이여야 합니다.");
    }
}
