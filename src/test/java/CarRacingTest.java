import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @ParameterizedTest
    @CsvSource(value = {"4,1", "3,0"})
    void 난수가_4_이상이면_차가_전진한다(int forwardCondition, int result) {

        // given
        Car car = new Car();

        // when
        car.go(forwardCondition);

        // then
        assertThat(car.distance()).isEqualTo(result);
    }

}
