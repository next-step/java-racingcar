package carRacing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {

    @Test
    @DisplayName("자동차는 4 이상일 경우 전진할 수 있다.")
    void move() {
        Car car = new Car();
        int result = car.move(4);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 랜덤 값이 4 이상일 경우 전진할 수 있다.")
    void random_move() {
        Car car = new Car();
        int result = car.move();
        assertThat(result).isEqualTo(1);
    }

}
