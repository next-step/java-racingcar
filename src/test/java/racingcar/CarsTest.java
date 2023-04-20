package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

@DisplayName("자동차 개수를 입력하여 생성한 Cars 객체 테스트")
public class CarsTest {

    @DisplayName("입력받은 차의 이름 수 만큼 Car 를 생성한다")
    @ParameterizedTest
    @ValueSource(strings = {"korea, japan, china"})
    void carSizeTest(String input) {
        Cars cars = new Cars(input);

        Assertions.assertThat(cars.findCarsCount()).isEqualTo(3);
    }
}
