package test.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.Car.moveCar;

public class RacingTest {

    @DisplayName("숫자 4이상일때")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void 숫자4이상(int number){
        Car car = new Car(0);

        assertThat(1).isEqualTo(moveCar(car,number));
    }

    @DisplayName("숫자 4미만일때")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 숫자4미만(int number){
        Car car = new Car(0);

        assertThat(0).isEqualTo(moveCar(car,number));
    }



}
