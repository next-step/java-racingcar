package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @ParameterizedTest
    @CsvSource(value = {"true|1", "false|0"}, delimiter = '|')
    @DisplayName("step3. 차량 이동")
    public void testMoveCaseOfTrue(boolean isMove, int position) {
        Car car = new Car();
        car.move(isMove);
        assertThat(car.getPosition()).isEqualTo(position);
    }
}