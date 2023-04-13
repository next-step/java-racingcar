import car.Car;
import car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import record.CarRecord;
import record.Records;
import strategy.RandomStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class CarRacingTest {

    @ParameterizedTest(name = "전진 전략이 {0}이면 차의 주행거리가 {1} 증가한다.")
    @CsvSource(value = {"true,1", "false,0"})
    void 전진조건이_참이면_차가_전진한다(boolean condition, int result) {

        // given
        Car car = new Car("car");

        // when
        car.go(() -> condition);

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
        loser.go(() -> false);
        winner.go(() -> true);

        List<Car> carList = Arrays.asList(loser, winner);
        Cars cars = new Cars(carList, new RandomStrategy());
        Records records = new Records();

        // when
        records.add(cars);
        records.addWinners();

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(1);
            softAssertions.assertThat(result.get(0).name()).isEqualTo("jack");
            softAssertions.assertThat(result.get(0).distance())
                    .isGreaterThan(loser.distance());
        });
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {

        // given
        Car firstWinner = new Car("alex");
        Car secondWinner = new Car("jack");
        firstWinner.go(() -> true);
        secondWinner.go(() -> true);

        List<Car> carList = Arrays.asList(firstWinner, secondWinner);
        Cars cars = new Cars(carList, new RandomStrategy());
        Records records = new Records();

        // when
        records.add(cars);
        records.addWinners();

        List<CarRecord> result = records.winners();

        // then
        assertSoftly(softAssertions -> {
            softAssertions.assertThat(result).hasSize(2);
            softAssertions.assertThat(result.get(0).name()).isEqualTo("alex");
            softAssertions.assertThat(result.get(1).name()).isEqualTo("jack");
            softAssertions.assertThat(result.get(0).distance())
                    .isEqualTo(result.get(1).distance());
        });
    }

    @Test
    void 콤마로_구분된_이름만큼_차가_생성된다() {

        // given
        String[] nameOfCars = {"alex", "jake"};

        // when
        Cars result = Cars.make(nameOfCars);

        // then
        assertThat(result.cars()).hasSize(2);
    }


    @Test
    void 주행_거리는_차의_개수와_시도_횟수를_곱한_만큼_기록된다() {

        // given
        String[] nameOfCars = {"alex", "jake"};
        RacingGame game = new RacingGame(nameOfCars);

        // when
        Records records = game.start(5);

        // then
        assertThat(records.gameRecord()).hasSize(10);
    }
}
