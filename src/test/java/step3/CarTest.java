package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @DisplayName("car.move()를 호출하면 car.state가 1 증가한다")
    @Test
    public void test1(){
        Car car = new Car();
        car.move();

        Assertions.assertThat(car.getState()).isEqualTo(1);
    }
}