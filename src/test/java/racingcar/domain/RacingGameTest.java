package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
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
    class DescribeNewConstructor {

        private final int defaultRound = 0;
        private final List<Car> defeaultCars = List.of(
            new Car("win1", trueMover),
            new Car("loser", falseMover),
            new Car("win2", trueMover)
        );

        @Nested
        @DisplayName("자동차 클래스들과 라운드 정보가 주어진다면,")
        class ContextCarsInput {

            @Test
            @DisplayName("생성을 성공 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new RacingGame(defaultRound, defeaultCars));
            }

        }

        @Nested
        @DisplayName("Cars에 중복된 이름의 Car가 있다면,")
        class ContextDuplicateCarsNameInput {

            private final List<Car> duplicateNameCars = List.of(
                new Car("A", trueMover),
                new Car("A", falseMover),
                new Car("A", trueMover)
            );

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(defaultRound, duplicateNameCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("Empty List가 Cars로 주어진다면,")
        class ContextEmptyCarsInput {

            private final List<Car> emptyCars = List.of();

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(defaultRound, emptyCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

        @Nested
        @DisplayName("round 값으로 -1이 주어진다면,")
        class ContextNegativeRoundInput {

            private final int negativeRound = -1;

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void ItThrowIllegalArgumentException() {
                assertThatThrownBy(() -> new RacingGame(negativeRound, defeaultCars)).isInstanceOf(
                    IllegalArgumentException.class);
            }

        }

    }

    @Nested
    @DisplayName("play 메소드는")
    class DescribePlayMethod {

        private final List<Car> cars = List.of(
            new Car("A", falseMover),
            new Car("B", falseMover),
            new Car("C", trueMover)
        );

        @Nested
        @DisplayName("RacingGame의 round필드가 1로 바인딩 되어있다면,")
        class ContextRacingGameRound1 {

            private final int round = 1;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final int moveCount = 1;
            private final List<Car> expectedCars = getExpectedCars(cars, moveCount);

            @Test
            @DisplayName("한판을 진행하고, 그 결과를 car에 반영한다.")
            void ItReturn1RoundResult() {
                racingGame.play();
                assertEqualAllCars(cars, expectedCars);
            }

        }

        @Nested
        @DisplayName("RacingGame의 round필드가 3으로 바인딩 되어있다면,")
        class ContextRacingGameRound3 {

            private final int round = 3;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final int moveCount = 3;
            private final List<Car> expectedCars = getExpectedCars(cars, moveCount);

            @Test
            @DisplayName("세판을 진행하고, 그 결과를 car에 반영한다.")
            void ItReturn1RoundResult() {
                racingGame.play();

                assertEqualAllCars(cars, expectedCars);
            }

        }

    }

    @Nested
    @DisplayName("getRoundResult 메소드는")
    class DescribeRoundResultMethod {

        private final List<Car> cars = List.of(
            new Car("A", falseMover),
            new Car("B", falseMover),
            new Car("C", trueMover)
        );

        @Nested
        @DisplayName("play가 실행된 이후 호출하면,")
        class ContextCall {

            private final int round = 1;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final int moveCount = 1;
            private final List<Car> expectedCars = getExpectedCars(cars, moveCount);

            @Test
            @DisplayName("현재 라운드의 결과를 반환한다.")
            void ItReturnRoundResult() {
                racingGame.play();
                List<Car> roundResult = racingGame.getRoundResult();
                assertEqualAllCars(roundResult, expectedCars);
            }

        }

        @Nested
        @DisplayName("play가 두번 호출된 후, 호출되면")
        class ContextCallBeforePlayTwice {

            private final int round = 2;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final int moveCount = 2;
            private final List<Car> expectedCars = getExpectedCars(cars, moveCount);

            @Test
            @DisplayName("두번째 라운드의 결과를 반환한다.")
            void ItReturnTwiceRoundResult() {
                racingGame.play();
                List<Car> roundResult = racingGame.getRoundResult();
                assertEqualAllCars(roundResult, expectedCars);
            }

        }

    }

    @Nested
    @DisplayName("getWinners 메소드는")
    class ContextGetWinnersMethod {

        private final List<Car> cars = List.of(
            new Car("win1", trueMover),
            new Car("win2", trueMover),
            new Car("loser", falseMover)
        );

        @Nested
        @DisplayName("한판 진행 후 호출되면,")
        class DescribeCall {

            private final int round = 1;
            private final RacingGame racingGame = new RacingGame(round, cars);
            private final int moveCount = 1;
            private final List<Car> expectedCars = getExpectedCars(cars, moveCount);

            @Test
            @DisplayName("우승자들을 반환한다.")
            void ItReturnRoundResult() {
                racingGame.play();
                List<Car> roundResult = racingGame.getWinners();
                assertEqualAllCars(roundResult, expectedCars);
            }

        }

    }

    private List<Car> getExpectedCars(List<Car> cars, int moveCount) {
        List<Car> copy = List.copyOf(cars);
        for (Car car : copy) {
            moveCar(car, moveCount);
        }
        return copy;
    }

    private void moveCar(Car car, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            car.move();
        }
    }

    private void assertEqualAllCars(List<Car> result, List<Car> expected) {
        assertThat(result).containsAll(expected);
    }
}
