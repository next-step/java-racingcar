package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @DisplayName("car 전진시 currnetPosition 증가 테스트")
    @Test
    void moveForwardTest() {
        Car car = new Car("test");
        car.moveForward(new ForwardTest().isSuccess());
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @DisplayName("car 전진 실패시 currentPosition 불변하는지 테스트")
    @Test
    void moveForwardFailTest(){
        Car car = new Car("test");
        car.moveForward(!new ForwardTest().isSuccess());
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 이름 5자 이상 설정시 에러 발생 테스트")
    @Test
    void carNameValidation() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("abcdef");
        });
    }

    @DisplayName("원하는 이름으로 자동차가 생성되는지 테스트")
    @Test
    void testCarName() {
        Car car = new Car("test");
        assertThat(car.getName()).isEqualTo("test");

    }
}
