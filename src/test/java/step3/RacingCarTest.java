package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.RacingCars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    @Test
    @DisplayName("사용자가 입력한 이름대로 자동차가 생성되어야 한다.")
    void testCreateCarsByInput() {
        List<String> carNames = List.of("car1", "car2", "car3");

        RacingCars racingCars = RacingCars.create(carNames);
        List<Car> cars = racingCars.getAll();

        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getName());
        }
    }

    @Test
    @DisplayName("이동거리가 가장 먼 자동차가 우승자이다.")
    void testGetWinner() {
        List<Car> cars = Arrays.asList(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );
        cars.get(1).move();
        Car expectedWinner = cars.get(1);
        RacingCars racingCars = new RacingCars(cars);

        List<Car> winners = racingCars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(expectedWinner).isSameAs(winners.get(0));
    }

    @Test
    @DisplayName("이동거리가 동일한 경우 우승자가 여러명일 수 있이다.")
    void testGetWinners() {
        List<Car> cars = Arrays.asList(
                new Car("car1"),
                new Car("car2"),
                new Car("car3")
        );
        cars.get(1).move();
        cars.get(2).move();
        List<Car> expectedWinners = Arrays.asList(cars.get(1), cars.get(2));
        RacingCars racingCars = new RacingCars(cars);

        List<Car> winners = racingCars.getWinner();

        assertThat(winners).hasSize(2);
        assertEquals(expectedWinners, winners);
    }
}
