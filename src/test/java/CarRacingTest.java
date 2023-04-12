import car.Car;
import car.Cars;
import record.Records;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import strategy.MovingStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarRacingTest {

    @ParameterizedTest(name = "전진 전략이 {0}이면 차의 주행거리가 {1} 증가한다.")
    @MethodSource("provideStrategy")
    void 전진조건이_참이면_차가_전진한다(MovingStrategy strategy, int result) {

        // given
        Car car = new Car("car");
        MovingStrategy movingStrategy = strategy;

        // when
        car.go(movingStrategy);

        // then
        assertThat(car.distance()).isEqualTo(result);
    }

    @Test
    @DisplayName("차의 이름은 5자 초과가 될 수 없다.")
    void 차의_이름이_5자_초과이면_예외가_발생한다() {

        // given
        String testName = "abcdef";

        // then
        assertThatThrownBy(() -> new Car(testName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자 이상이 될 수 없습니다! : " + testName);
    }

    @Test
    void 주행_거리가_긴_자동차가_우승한다() {

        // given
        Car loser = new Car("alex");
        Car winner = new Car("jack");

        List<Car> carList = Arrays.asList(loser, winner);

        Cars cars = new Cars(carList);
        Records records = new Records();

        winner.go(new MovableStrategy());

        // when
        records.addWinners(cars);
        List<Car> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(1);
            softAssertions.assertThat(result).contains(winner);
        });
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {

        // given
        Car firstWinner = new Car("alex");
        Car secondWinner = new Car("jack");

        List<Car> carList = Arrays.asList(firstWinner, secondWinner);

        Cars cars = new Cars(carList);
        Records records = new Records();

        // when
        records.addWinners(cars);
        List<Car> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(2);
            softAssertions.assertThat(result).contains(firstWinner, secondWinner);
        });
    }

    private static Stream<Arguments> provideStrategy() {
        return Stream.of(
                Arguments.of(new MovableStrategy(), 1),
                Arguments.of(new NotMovableStrategy(), 0)
        );
    }
}
