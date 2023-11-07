package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CarGeneratorTest {

    private static final String[] NAME_OF_CARS = {"pobi", "crong", "honux"};

    @Test
    @DisplayName("생성된 자동차의 이름을 확인한다")
    public void 자동차_생성() {
        List<Car> cars = CarGenerator.generate(NAME_OF_CARS);
        assertThat(cars).extracting(Car::name).containsExactly(NAME_OF_CARS);
    }

}
