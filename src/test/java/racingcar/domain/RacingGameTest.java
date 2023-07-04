package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        private final int round = 5;

        @Nested
        @DisplayName("자동차 클래스들과 라운드 정보가 주어진다면,")
        class DescribeCarsInput {

            private final Car[] cars = {
                new Car("A", trueMover),
                new Car("B", falseMover),
                new Car("C", trueMover),
            };

            @Test
            @DisplayName("생성을 성공 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new RacingGame(round, cars));
            }

        }

        @Nested
        @DisplayName("Cars에 중복된 이름의 Car가 있다면,")
        class DescribeDuplicateCarsNameInput {

            private final Car[] duplicateNameCars = {
                new Car("A", trueMover),
                new Car("A", falseMover),
                new Car("A", trueMover),
            };

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(round, duplicateNameCars)).isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

}
