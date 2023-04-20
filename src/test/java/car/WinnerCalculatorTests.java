package car;

import car.dto.Car;
import car.service.InputValidator;
import car.service.WinnerCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class WinnerCalculatorTests {
    @Test
    @DisplayName("우승자 계산 - 1명")
    void calculateWinner_OneWinner() {
        // given
        Car pobi = new Car("pobi");
        pobi.move();
        Car crong = new Car("crong");

        List<Car> cars = Arrays.asList(pobi, crong);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("우승자 계산 - 2명 이상")
    void calculateWinner_MultipleWinners() {
        // given
        Car pobi = new Car("pobi");
        pobi.move();
        Car crong = new Car("crong");
        crong.move();
        Car honux = new Car("honux");

        List<Car> cars = Arrays.asList(pobi, crong, honux);

        // when
        List<Car> winners = WinnerCalculator.getWinners(cars);

        // then
        assertThat(winners.size()).isEqualTo(2);
    }
}
