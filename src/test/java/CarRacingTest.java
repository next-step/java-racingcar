import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    @ParameterizedTest(name = "전진 조건이 {0}이면 차의 주행거리가 {1} 증가한다.")
    @CsvSource(value = {"true,1", "false,0"})
    void 전진조건이_참이면_차가_전진한다(boolean condition, int result) {

        // given
        Car car = new Car();

        // when
        car.go(condition);

        // then
        assertThat(car.distance()).isEqualTo(result);
    }

}
