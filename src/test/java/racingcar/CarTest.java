package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("4이상일 경우 움직이는지 테스트")
    void 전진(){
        Car car = new Car( 0);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4이하일 경우 움직이는지 테스트")
    void 정지(){
        Car car = new Car(0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
