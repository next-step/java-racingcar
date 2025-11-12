package study.racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTest {

    @Test
    void 자동차를_생성하면_이름을_가진다() {
        Car yang = new Car("yang");
        assertThat(yang.getName()).isEqualTo("yang");
    }


    @Test
    void 자동차의_초기_위치는_0이다() {
        Car car = new Car("yang");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_전달받은_토크가_4이상이면_전진한다() {
        Car car = new Car("yang");
        car.move(new Torque(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_전달받은_토크가_4미만이면_정지한다() {
        Car car = new Car("yang");
        car.move(new Torque(3));
        assertEquals(0, car.getPosition());
        assertThat(car.getPosition()).isZero();
    }

    @Test
    void 자동차의_이름은_5글자까지_생성가능하다() {
        Car car = new Car("12345");
        assertEquals("12345", car.getName());
    }

    @Test
    void 자동차의_이름은_5자를_초과할수없다() {
        assertThatThrownBy(() -> new Car("1234567"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 최대 5글자를 초과할 수 없습니다.");
    }

}
