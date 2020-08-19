package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car();

    @DisplayName("car 전진시 이동 이력 쌓이는지 테스트")
    @Test
    void moveForwardTest(){
        for(int i = 0; i < 10; i++){
            car.moveForward(true);
        }

        assertThat(car.getPositionHistory().size()).isEqualTo(11);
    }
}
