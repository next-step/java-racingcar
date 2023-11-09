package ch3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    void 차는_위치를_가진다() {
        Car car = new Car();
        int result = car.position();
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 차는_4이상이면_전진한다() {
        Car car = new Car();
        car.move(4);
        int actual = car.position();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void 차는_4미만이면_멈춘다() {
        Car car = new Car();
        car.move(2);
        int actual = car.position();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void 차는_이름을_부여할_수_있다() {
        Car car = new Car();
        car.makeName("이창섭");
        assertThat(car.name()).isEqualTo("이창섭");
    }

    @Test 
    void 차의_이름은_5자를_초과할_수_없다() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.makeName("넥스트스텝 클린코드");
        }).isInstanceOf(RuntimeException.class)
        .hasMessage("이름은 5자를 초과할 수 없습니다");
    }

    @Test
    void 우승위치와_같은_위치면_우승차량이다() {
        Car car = new Car();
        assertTrue(car.isWinningCar(0));
    }

}
