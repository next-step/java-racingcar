package racingversion2.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4이상일 때 자동차를 한 칸 앞으로 움직인다.")
    void move(){
        Car car = new Car(CarName.of("jaden"), new Position());
        assertThat(car.getPosition()).isEqualTo(0);
        int movableValue = 4;
        car.move(movableValue);
        assertThat(car.getPosition()).isEqualTo(1);

        movableValue = 3;
        car.move(movableValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }


}