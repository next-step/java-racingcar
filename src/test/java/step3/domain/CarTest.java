package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
public class CarTest {
    Car car = new Car(0);

    @DisplayName("자동차가 움직이면 position이 증가")
    @Test
    public void increasePosition() {
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

}