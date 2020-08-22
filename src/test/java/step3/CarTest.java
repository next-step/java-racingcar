package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car = new Car();
    private ForwardTest forwardTest = new ForwardTest();

    @DisplayName("car 전진시 currnetPosition 증가 테스트")
    @Test
    void moveForwardTest(){
        if(forwardTest.successForward()){
            car.moveForward();
        }

        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }
}
