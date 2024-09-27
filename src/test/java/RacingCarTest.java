import car.RacingCar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar car;

    @BeforeEach
    void setCar() {
        car = new RacingCar();
    }

    @DisplayName("입력값이 4이상이면 차가 전진, 4미만이면 정지한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "4:2"}, delimiter = ':')
    void forwardTest(int input, int distance) {
        car.forward(input);
        assertThat(car.getDistance()).isEqualTo(distance);
    }

}
