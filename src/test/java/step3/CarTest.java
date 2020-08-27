package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    private Car car = new Car();
    private CarMovement forwardTest = () -> true;

    @DisplayName("car 전진시 currnetPosition 증가 테스트")
    @Test
    void moveForwardTest(){
        if(forwardTest.isSuccess()){
            car.moveForward(new ForwardTest().isSuccess());
        }

        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이름 5자 이상 설정시 에러 발생 테스트")
    @Test
    void carNameValidation(){
        assertThatIllegalArgumentException().isThrownBy(() ->{
            Car car = new Car("abcdef");
        });
    }
}
