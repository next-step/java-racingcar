package racingcar.randommove;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.extension.Moveable;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("RandomMover 테스트")
class RandomMoverTest {

    @Nested
    @DisplayName("isMove 메소드는")
    class DescribeIsMoveMethod {

        @Nested
        @DisplayName("RandomMover에 4가 들어오면,")
        class ContextReturn4 {

            private final Moveable randomMover = new RandomMover(() -> 4);

            @Test
            @DisplayName("true를 반환한다.")
            void ItReturnTrue() {
                assertThat(randomMover.isMove()).isTrue();
            }

        }

        @Nested
        @DisplayName("RandomMover에 3이 들어오면,")
        class ContextBinding3 {

            private final Moveable randomMover = new RandomMover(() -> 3);

            @Test
            @DisplayName("false를 반환한다.")
            void ItReturnFalse() {
                assertThat(randomMover.isMove()).isFalse();
            }

        }

    }

}
