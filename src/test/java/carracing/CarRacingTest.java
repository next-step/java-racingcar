package carracing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRacingTest {
    private CarRacing carRacing;
    private List<String> carNames;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        cars = new ArrayList<>();
        carNames = Arrays.asList("Acar", "Bcar", "Ccar");
        for(int i = 0; i < carNames.size(); i++) {
            cars.add(new Car(carNames.get(i)));
        }
        carRacing = new CarRacing(cars);
    }

    @Test
    void findWinnerTest() {
        cars.get(0).move(5);
        cars.get(1).move(3);
        cars.get(2).move(1);
        Assertions.assertThat(carRacing.makeWinners().get(0).toString()).isEqualTo("Acar");
    }
}
