package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 생성시 초기 위치 0을 반환한다.")
    void 자동차_생성() {
        Car car1 = new Car();
        Car car2 = new Car();

        assertThat(car1.getPosition()).isEqualTo(0);
        assertThat(car2.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("4이상의 숫자가 주어질 경우 자동차의 위치를 +1 하여 반영한다.")
    void 자동차_전진_4이상() {
        Car car1 = new Car();
        assertThat(car1.getPosition()).isEqualTo(0);

        CarEngine carEngine = new TestEngine(4);
        car1.move(carEngine);
        assertThat(car1.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자가 주어질 경우 자동차의 위치는 변함이 없어야 한다.")
    void 자동차_멈춤_4미만() {
        Car car1 = new Car();
        assertThat(car1.getPosition()).isEqualTo(0);

        CarEngine carEngine = new TestEngine(3);
        car1.move(carEngine);
        assertThat(car1.getPosition()).isEqualTo(0);
    }
}
