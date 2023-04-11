import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRacingTest {

    @ParameterizedTest(name = "전진 조건이 {0}이면 차의 주행거리가 {1} 증가한다.")
    @CsvSource(value = {"true,1", "false,0"})
    void 전진조건이_참이면_차가_전진한다(boolean condition, int result) {

        // given
        Car car = new Car("car", 0);

        // when
        car.go(condition);

        // then
        assertThat(car.distance()).isEqualTo(result);
    }

    @Test
    @DisplayName("차의 이름은 5자 초과가 될 수 없다.")
    void 차의_이름이_5자_초과이면_예외가_발생한다() {

        // given
        String testName = "abcdef";

        // then
        assertThatThrownBy(() -> new Car(testName, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 5자 이상이 될 수 없습니다! : " + testName);
    }

    @Test
    void 주행_거리가_긴_자동차가_우승한다() {

        // given
        Car loser = new Car("alex", 1);
        Car winner = new Car("jack", 2);

        List<Car> carList = Arrays.asList(loser, winner);

        Cars cars = new Cars(carList);
        Records records = new Records();

        // when
        records.addWinners(cars);
        List<Car> result = records.winners();

        // then
        assertThat(result).hasSize(1);
        assertThat(result).contains(winner);
    }

    @Test
    void 우승자는_한명_이상일_수_있다() {

        // given
        Car firstWinner = new Car("alex", 2);
        Car secondWinner = new Car("jack", 2);

        List<Car> carList = Arrays.asList(firstWinner, secondWinner);

        Cars cars = new Cars(carList);
        Records records = new Records();

        // when
        records.addWinners(cars);
        List<Car> result = records.winners();

        // then
        assertThat(result).hasSize(2);
        assertThat(result).contains(firstWinner, secondWinner);
    }
}
