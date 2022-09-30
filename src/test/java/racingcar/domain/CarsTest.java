package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Cars 클래스의 makeCars 메서드는 입력되는 차의 대수만큼 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {3, 5})
    void makeCars(int num) {
        List<Car> cars = Cars.makeCars(num);
        assertThat(cars).hasSize(num);
    }
}