package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingStarterTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("prepareCar() 메서드는 입력값 만큼의 길이를 가진 Car 리스트를 반환한다")
    void prepare_int_to_array(int input) {
        List<Car> cars = PrepareRacing.prepareCar(input);
        int carCount = cars.size();
        assertThat(carCount).isEqualTo(input);
    }
}