package test.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("숫자 4이상일때")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    public void 숫자4이상(int number){
        Car car = new Car();

        car.moveCar(number);

        assertThat(1).isEqualTo(car.getMoveCount());
    }

    @DisplayName("숫자 4미만일때")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 숫자4미만(int number){
        Car car = new Car();
        car.moveCar(number);
        assertThat(0).isEqualTo(car.getMoveCount());
    }

    @DisplayName("랜덤값")
    @ParameterizedTest
    @ValueSource(ints = {10})
    public void 랜덤값(int number){
        Racing racing = new Racing();

        assertThat(number).isGreaterThan(racing.randomNumber());
    }


}
