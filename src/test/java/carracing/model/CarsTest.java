package carracing.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7})
    @DisplayName("입력 수 만큼 자동차 수 생성 확인")
    void inputEqualsSize(Integer input) {
        Cars cars = new Cars(input);
        assertThat(cars.getSize()).isEqualTo(input);
    }

}
