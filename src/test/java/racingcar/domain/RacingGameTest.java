package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.extension.Moveable;

@DisplayName("RacingGame 클래스")
class RacingGameTest {

    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("new 생성자는")
    class ContextNewConstructor {

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
                assertThatThrownBy(() -> new RacingGame(round, duplicateNameCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("Round값이 1미만으로 주어진다면,")
        class DescribeRoundParameterUnderZero {

            private final Integer round = 0;
            private final Car[] cars = {new Car("A", trueMover)};

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(round, cars)).isInstanceOf(IllegalArgumentException.class);
            }

        }

    }

    @Nested
    @DisplayName("play 메소드는")
    class ContextPlayMethod {

        private final Car[] cars = {
            new Car("A", falseMover),
            new Car("B", falseMover),
            new Car("C", trueMover),
        };

        @Nested
        @DisplayName("RacingGame의 round가 1로 바인딩 되어있다면,")
        class DescribeRacingGameRound1 {

            private final Integer round = 1;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final Car[] expectedCars = move();

            @Test
            @DisplayName("한판을 진행하고, 그 결과를 car에 반영한다.")
            void ItReturn1RoundResult() {
                racingGame.play();
                for (int i = 0; i < cars.length; i++) {
                    Assertions.assertThat(cars[i]).isEqualTo(expectedCars[i]);
                }
            }

            private Car[] move() {
                Car[] copy = {
                    new Car("A", falseMover),
                    new Car("B", falseMover),
                    new Car("C", trueMover),
                };
                for (Car car : copy) {
                    car.move();
                }
                return copy;
            }

        }

    }

}
