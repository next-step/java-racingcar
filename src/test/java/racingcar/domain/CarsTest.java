package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.Moveable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Cars 클래스")
class CarsTest {

    private final Moveable trueMover = () -> true;
    private final Moveable falseMover = () -> false;

    @Nested
    @DisplayName("new 생성자는")
    class DescribeNewConstructor {

        @Nested
        @DisplayName("자동차 클래스들이 주어진다면,")
        class ContextCarsInput {

            private final List<Car> cars = List.of(
                    new Car("A", trueMover),
                    new Car("B", falseMover),
                    new Car("C", trueMover)
            );

            @Test
            @DisplayName("생성을 성공 한다.")
            void ItCreated() {
                assertThatNoException().isThrownBy(() -> new Cars(cars));
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
                assertThatThrownBy(() -> new Cars(duplicateNameCars)).isInstanceOf(
                        IllegalArgumentException.class);
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
        @DisplayName("playOneRound가 실행된 이후 호출하면,")
        class ContextCall {

            private final Cars cars = new Cars(DescribeRoundResultMethod.this.cars);

            private final List<Car> expectedCars = getExpectedCars();

            @Test
            @DisplayName("현재 라운드의 결과를 반환한다.")
            void ItReturnRoundResult() {
                List<Car> roundResult = cars.playOneRound();
                assertEqualAllCars(roundResult, expectedCars);
            }

            private List<Car> getExpectedCars() {
                List<Car> copy = List.of(
                        new Car("A", falseMover),
                        new Car("B", falseMover),
                        new Car("C", trueMover)
                );
                for (Car car : copy) {
                    car.move();
                }
                return copy;
            }

        }

        @Nested
        @DisplayName("playOneRound가 두번 호출된 후, 호출되면")
        class ContextCallBeforePlayTwice {

            private final Cars cars = new Cars(DescribeRoundResultMethod.this.cars);

            private final List<Car> expectedCars = getExpectedCars();

            @Test
            @DisplayName("두번째 라운드의 결과를 반환한다.")
            void ItReturnTwiceRoundResult() {
                cars.playOneRound();
                List<Car> roundResult = cars.playOneRound();
                assertEqualAllCars(roundResult, expectedCars);
            }

            private List<Car> getExpectedCars() {
                List<Car> copy = List.of(
                        new Car("A", falseMover),
                        new Car("B", falseMover),
                        new Car("C", trueMover)
                );
                for (Car car : copy) {
                    car.move();
                    car.move();
                }
                return copy;
            }

        }

    }

    @Nested
    @DisplayName("playOneRound 메소드는")
    class DescribePlayMethod {

        private final List<Car> cars = List.of(
                new Car("A", falseMover),
                new Car("B", falseMover),
                new Car("C", trueMover)
        );

        @Nested
        @DisplayName("한 번 호출되면,")
        class ContextCarsRound1 {

            private final Cars cars = new Cars(DescribePlayMethod.this.cars);
            private final List<Car> expectedCars = getExpectedCars();

            @Test
            @DisplayName("한 라운드를 진행하고, 그 결과를 반환한다.")
            void ItReturn1RoundResult() {
                List<Car> oneRoundAfterCars = cars.playOneRound();
                assertEqualAllCars(oneRoundAfterCars, expectedCars);
            }

            private List<Car> getExpectedCars() {
                List<Car> copy = List.of(
                        new Car("A", falseMover),
                        new Car("B", falseMover),
                        new Car("C", trueMover)
                );
                for (Car car : copy) {
                    car.move();
                }
                return copy;
            }

        }

        @Nested
        @DisplayName("세 번 호출되면,")
        class ContextCarsRound3 {

            private final Cars cars = new Cars(DescribePlayMethod.this.cars);
            private final List<Car> expectedCars = getExpectedCars();

            @Test
            @DisplayName("세 라운드를 진행하고, 그 결과를 반환한다.")
            void ItReturn1RoundResult() {
                cars.playOneRound();
                cars.playOneRound();
                List<Car> threeRoundAfterCars = cars.playOneRound();

                assertEqualAllCars(threeRoundAfterCars, expectedCars);
            }

            private List<Car> getExpectedCars() {
                List<Car> copy = List.of(
                        new Car("A", falseMover),
                        new Car("B", falseMover),
                        new Car("C", trueMover)
                );

                for (Car car : copy) {
                    car.move();
                    car.move();
                    car.move();
                }
                return copy;
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
        @DisplayName("한 판 진행 후 호출되면,")
        class DescribeCall {

            private final Cars cars = new Cars(ContextGetWinnersMethod.this.cars);

            private final List<Car> expectedCars = getExpectedCars();

            @Test
            @DisplayName("우승자들을 반환한다.")
            void ItReturnRoundResult() {
                cars.playOneRound();
                List<Car> roundResult = cars.getWinners();
                assertEqualAllCars(roundResult, expectedCars);
            }

            private List<Car> getExpectedCars() {
                List<Car> copy = List.of(
                        new Car("win1", trueMover),
                        new Car("win2", trueMover)
                );
                for (Car car : copy) {
                    car.move();
                }
                return copy;
            }

        }

    }

    private void assertEqualAllCars(List<Car> result, List<Car> expected) {
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertThat(result.get(i)).isEqualTo(expected.get(i));
        }
    }
}
