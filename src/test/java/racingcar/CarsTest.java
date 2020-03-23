package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        Car car = new Car("Mark", 5);
        Car car2 = new Car("Johnny", 5);
        Car car3 = new Car("Jaehyun", 1);
        cars = new Cars(Arrays.asList(car, car2, car3));
    }

    @DisplayName("자동차 객체 중 가장 높은 position 값을 리턴한다.")
    @Test
    void findHighestPositionValueTest() {
        //when
        int highestPositionValue = cars.findHighestPositionValue();

        //then
        assertThat(highestPositionValue).isEqualTo(5);
    }

    @DisplayName("position 값이 가장 높은 사람이 우승자이다.")
    @Test
    void findWinnerTest() {
        //when
        List<Car> winners = cars.findWinner();

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains(new Car("Mark", 5));
        assertThat(winners).contains(new Car("Johnny", 5));
    }
}