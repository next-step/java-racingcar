import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.Racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class racingCarTest {

    @Test
    @DisplayName("0~9 사이의 랜덤값을 구하는 테스트")
    public void testRandom() {
        int randomValue = Racingcar.getRandomValue();
        assertThat(randomValue < 10).isTrue();
    }

    @Test
    @DisplayName("자동차가 움직이는지 테스트")
    public void testIsMovingCar() {
        Car car = new Car();
        car.move();
        assertThat(car.getDistinct()).isEqualTo(1);
    }
}
