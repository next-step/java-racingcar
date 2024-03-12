import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import racingcar.Racingcar;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class racingCarTest {

    @Test
    @DisplayName("0~9 사이의 랜덤값을 구하는 테스트")
    public void testRandom() {
        int randomValue = Racingcar.getRandomValue();
        assertThat(randomValue < 10).isTrue();
    }

    @ParameterizedTest
    @DisplayName("4이상일 경우 전진하는 조건인지 테스트")
    @CsvSource({"3,false", "5,true", "8,true"})
    public void testIsMoving(int input, boolean output) {
        boolean isMoving = Racingcar.isMovingForward(input);
        assertThat(isMoving).isEqualTo(output);
    }

    @Test
    @DisplayName("자동차가 움직이는지 테스트")
    public void testIsMovingCar() {
        Car car = new Car();
        car.move();
        assertThat(car.getDistinct()).isEqualTo(1);
    }
}
