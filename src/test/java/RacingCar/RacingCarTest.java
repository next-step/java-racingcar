package RacingCar;

import RacingCar.Model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    @ParameterizedTest
    @DisplayName("random 값이 4이상일 경우에만 전진")
    @CsvSource(value = {"0,false", "1,false", "2,false", "3,false", "4,true", "5,true", "6,true"})
    void carMoveTest(int num, boolean isGo) {
        Car car = new Car();
        car.moveCar(num);
        String stringCurrentState = car.makeStringCurrentState();
        assertThat(stringCurrentState.equals("-")).isEqualTo(isGo);
    }
}
