package step4.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final String CAR_NAMES_FOR_TEST = "car1,car2,car3";

    private CarNames carNames = CarNames.from(CAR_NAMES_FOR_TEST);
    private Cars cars = Cars.of(carNames);

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void 입력된_이름들로_자동차들을_생성한다(int num) {
        assertThat(cars.getCars().get(num))
                .isEqualTo(new Car("car" + (num + 1)));
    }

}
