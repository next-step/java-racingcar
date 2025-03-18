package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    @DisplayName("초기 Car는 0이다.")
    public void initializeCar(){
        assertThat(new Car(0, "crong").getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 4이상의 값이 나오면 움직일 수 있다.")
    public void move(){
        Car car = new Car(0, "crong");
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 3이하의 값이 나오면 움직일 수 없다.")
    public void stop(){
        Car car = new Car(0, "crong");
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }
}