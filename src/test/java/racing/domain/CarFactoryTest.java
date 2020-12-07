package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 공장(CarFactory) 테스트")
public class CarFactoryTest {

    @DisplayName("자동차들을 만들 수 있다.")
    @Test
    void create() {
        // given
        CarFactory carFactory = names -> Cars.of(Arrays.asList(Car.of("yohan")));

        // when
        Cars cars = carFactory.create("");

        // then
        assertThat(cars).isNotNull();
    }
}
