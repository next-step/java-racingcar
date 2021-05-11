package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacingTest {
    CarRacing carRacing;

    @BeforeEach
    void setUp() {
        carRacing = new CarRacing();
    }

    @Test
    void makeWinningTest() {
        List<String> carNames = Arrays.asList("Acar", "Bcar", "Ccar");
        List<Car> cars = new ArrayList<>();
        for(int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i)));
        }
        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(1);
        Assertions.assertThat(carRacing.makeWinners(cars).get(0)).isEqualTo("Acar");
    }
}
