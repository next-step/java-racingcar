package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

@DisplayName("자동차 개수를 입력하여 생성한 Cars 객체 테스트")
public class CarsTest {

    @DisplayName("입력받은 숫자만큼 Car 를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6})
    void carSizeTest(int input) {
        Cars cars = new Cars(input);

        Assertions.assertThat(cars.findAllCars()).hasSize(input);
    }
}
