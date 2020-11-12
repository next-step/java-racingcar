package study.racing4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 이름 확인")
    public void 자동차_이름_확인() {

        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");

    }

    @Test
    @DisplayName("자동차 위치 확인")
    public void 자동차_위치_확인() {

        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("자동차 이동 확인")
    public void 자동차_이동_확인() {

        Car car = new Car("pobi");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차 올바르지 않은 이름_확인")
    public void 자동차_올바르지_않은_이름_확인() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car car = new Car("javaKing");
                }).withMessageContaining("자동차의 이름은 5자를 넘지 않아야 합니다.");

    }

    @Test
    @DisplayName("자동차 잘못된 위치 확인")
    public void 자동차_잘못된_위치_확인() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Car car = new Car("pobi", -1);
                }).withMessageContaining("자동차의 위치는 음수 일 수 없습니다.");

    }

}
