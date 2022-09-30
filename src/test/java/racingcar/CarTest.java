package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("4이상일 경우 움직이는지 테스트")
    void 전진(){
        Car car = new Car("car1");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4이하일 경우 움직이는지 테스트")
    void 정지(){
        Car car = new Car("car2");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("Car 인스턴스 생성시 position 음수값일 경우 에러 발생")
    void 생성자_음수입력() {
        assertThatThrownBy(() -> new Car("car1",-1))
                .isInstanceOf(RuntimeException.class);
    }
}
