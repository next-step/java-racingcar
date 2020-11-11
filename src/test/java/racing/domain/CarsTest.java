package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarsTest {

    @ParameterizedTest
    @ValueSource(strings = "next,step,yoon")
    @DisplayName("자동차를 10대 생성하여 생성된 자동차 수 확인")
    void 자동차_대수_확인(String names) {
        // given
        String[] carNames = names.split(",");

        // when
        Cars cars = new Cars(Arrays.stream(carNames).map(Car::new)
                .collect(Collectors.toList()));
        // then
        assertThat(cars.getCars()).containsExactly(
                new Car("next"),new Car("step"),new Car("yoon")
        );
    }

}
