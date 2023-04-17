package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("3단계 - 자동차 경주 - 자동차 객체가 생성되는지 확인")
    @Test
    void create_car() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
