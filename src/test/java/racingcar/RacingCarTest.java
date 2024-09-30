package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car();
    }

    @ParameterizedTest
    @DisplayName("random 값이 4 이상일 때, 차가 앞으로 1만큼 이동한다.")
    @CsvSource({"3, 0", "4, 1", "5, 1", "9, 1"})
    void forwardCarBasedOnRandomNumber(final int randomNumber, final int currentPoint) {
        //given
        car.move(randomNumber);
        //then
        assertThat(car.getPoint()).isEqualTo(currentPoint);
    }

}
