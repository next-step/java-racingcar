package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.CarFactory;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarFactoryTest {

    private List<String> carNames;

    @BeforeEach
    public void setUp() {
        carNames = new ArrayList<>();
        carNames.add("car1");
        carNames.add("car2");
        carNames.add("car3");
    }

    @Test
    public void 사용자가_입력한만큼의_자동차를_생성해야한다() {
        Cars cars = CarFactory.createRacingCars(carNames);
        assertThat(cars.isSize(3)).isTrue();
    }
}
