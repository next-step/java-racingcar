package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_랜덤값4이상인경우_자동차는_전진한다() {
        Car car = new Car();
        car.move(4);
        assertThat(car).isEqualTo(new Car(1));
    }

    @Test
    void move_랜덤값4미만인경우_자동차는_현위치를유지한다() {
        Car car = new Car();
        car.move(3);
        assertThat(car).isEqualTo(new Car());
    }

    @DisplayName("현재 자동차 위치를 hyphen으로 변환한 문자열을 반환한다")
    @Test
    void hyphenatePosition() {
        Car car = new Car(5);
        assertThat(car.hyphenatePosition()).isEqualTo("-----");
    }
}
