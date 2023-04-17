package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.RacingCars;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingCarTest {
    @Test
    @DisplayName("사용자가 입력한 이름대로 자동차가 생성되어야 한다.")
    void testCreateCarsByInput() {
        List<String> carNames = List.of("car1", "car2", "car3");

        RacingCars racingCars = new RacingCars(carNames);
        List<Car> cars = racingCars.getAll();

        for (int i = 0; i < carNames.size(); i++) {
            assertEquals(carNames.get(i), cars.get(i).getName());
        }
    }
}
