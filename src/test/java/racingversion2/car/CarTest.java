package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차를 한 칸 앞으로 움직인다.")
    void move(){
        Car car = new Car(CarName.of("jaden"), new Position());
        assertThat(car.getPosition()).isEqualTo(0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}