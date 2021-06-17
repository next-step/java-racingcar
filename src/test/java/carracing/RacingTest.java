package carracing;

import carracing.model.Car;
import carracing.model.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Cars cars;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList(new Car("Acar", 1), new Car("Bcar", 2),
                new Car("Ccar", 1)));
    }

    @DisplayName("자동차 경주의 우승자는 `위치`값이 가장 높은 자동차이다.")
    @Test
    void findWinnerTest() {
        assertThat(cars.makeWinners()).contains("Bcar");
    }
}
