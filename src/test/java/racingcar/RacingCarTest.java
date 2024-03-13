package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("랜덤값이 4이상일 경우 전진")
    @ValueSource(ints = {4,5,6,7,8,9})
    void careMove(int number){
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("랜덤값이 4미만일 경우 정지")
    @ValueSource(ints = {1,2,3})
    void carNotMove(int number){
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(number);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
