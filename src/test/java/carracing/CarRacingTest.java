package carracing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    private CarRacing carRacing;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = Arrays.asList(new Car("Acar"), new Car("Bcar"),
                new Car("Ccar"));
        carRacing = new CarRacing(cars);
    }

    @DisplayName("자동차 경주의 우승자는 가장 많이 움직인 자동차이다.")
    @Test
    void findWinnerTest() {
        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(1);
        assertThat(carRacing.makeWinners().get(0)).isEqualTo("Acar");
    }
}
