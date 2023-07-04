package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.extension.Moveable;

@DisplayName("RacingGame 클래스")
class RacingGameTest {

    @Nested
    @DisplayName("new 생성자는")
    class ContextNewConstructor {

        private final Moveable trueMover = () -> true;
        private final Moveable falseMover = () -> false;

        @Nested
        @DisplayName("자동차 클래스들이 주어진다면,")
        class DescribeCarsInput {

            private final Car[] cars = {
                new Car("A", trueMover),
                new Car("B", falseMover),
                new Car("C", trueMover),
            };

            @Test
            @DisplayName("생성을 성공 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new RacingGame(cars));
            }

        }

    }

}
