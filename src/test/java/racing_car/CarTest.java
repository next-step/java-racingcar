package racing_car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing_car.strategy.ForTestStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "True:1",
            "False:0"
    },
            delimiter = ':')
    public void test(boolean isMove, int expected) {
        Car car = new Car("name", new ForTestStrategy(() -> isMove));

        car.move();

        assertThat(car.getLocation()).isEqualTo(expected);
    }

}
