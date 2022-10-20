package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class WinnerTest {

    @Test
    void findMaxPositionTest() {
        Car car1 = new Car("자동차1", 3);
        Car car2 = new Car("자동차2", 2);
        Car car3 = new Car("자동차3", 5);
        List<Car> carList = Arrays.asList(car1, car2, car3);

        Winner winner = new Winner(carList);
        assertThat(winner.findMaxPosition()).isEqualTo(new Position(5));
    }

    @Test
    void findWinnersTest() {
        Car car1 = new Car("자동차1", 3);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차3", 2);
        Car car4 = new Car("자동차4", 5);
        List<Car> listOneWinner = Arrays.asList(car1, car2, car3, car4);
        List<Car> listWinners = Arrays.asList(car1, car2, car3);

        Winner oneWinner = new Winner(listOneWinner);
        Winner winners = new Winner(listWinners);
        assertThat(oneWinner.findWinners()).isEqualTo(Arrays.asList(car4));
        assertThat(winners.findWinners()).isEqualTo(Arrays.asList(car1, car2));
    }

    @Test
    void findWinnersNameTest() {
        Car car1 = new Car("자동차1", 3);
        Car car2 = new Car("자동차2", 3);
        Car car3 = new Car("자동차3", 2);
        Car car4 = new Car("자동차4", 5);
        List<Car> listOneWinner = Arrays.asList(car1, car2, car3, car4);
        List<Car> listWinners = Arrays.asList(car1, car2, car3);

        Winner oneWinner = new Winner(listOneWinner);
        Winner winners = new Winner(listWinners);
        assertThat(oneWinner.findWinnersName()).isEqualTo("자동차4");
        assertThat(winners.findWinnersName()).isEqualTo("자동차1,자동차2");
    }
}