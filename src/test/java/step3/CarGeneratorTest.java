package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CarGeneratorTest {

    private static final int NUMBER_OF_CARS = 3;

    @Test
    @DisplayName("생성된 자동차 수를 확인한다")
    public void 자동차_대수() {
        List<Car> cars = CarGenerator.generate(NUMBER_OF_CARS);
        assertThat(cars).hasSize(NUMBER_OF_CARS);
    }

}
