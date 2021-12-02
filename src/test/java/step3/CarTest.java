package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    Car car = new Car();

    @Test
    @DisplayName("랜덤 값이 4 미만이면 이동을 하지 않는지 테스트")
    public void stopTest(){
        car.move(2);
        assertThat(car.getTravelDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("랜덤 값이 4 이면 이동을 하지 않는지 테스트")
    public void stopTest4(){
        car.move(4);
        assertThat(car.getTravelDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4 이상이면 이동하는지 테스트")
    public void moveTest(){

        car.move(7);
        assertThat(car.getTravelDistance()).isEqualTo(1);
    }
}
