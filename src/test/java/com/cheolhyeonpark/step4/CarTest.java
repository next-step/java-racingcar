package com.cheolhyeonpark.step4;

import com.cheolhyeonpark.step4.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("true값을 매개변수로 move 메서드를 실행하면 car의 position이 1 증가한다")
    public void moveWhenParameterIsTrue() {
        //given
        Car car = new Car("test", 0);

        //when
        car.move(true);

        //then
        assertThat(car).isEqualTo(new Car("test", 1));
        assertThat(car.hashCode()).isEqualTo(new Car("test", 1).hashCode());
    }

    @Test
    @DisplayName("false값을 매개변수로 move 메서드를 실행하면 car의 position이 증가하지 않는다")
    public void moveWhenParameterIsFalse() {
        //given
        Car car = new Car("test", 0);

        //when
        car.move(false);

        //then
        assertThat(car).isEqualTo(new Car("test", 0));
    }

    @Test
    @DisplayName("getName() 메서드를 호출하면 자동차의 이름이 반환된다")
    public void getName() {
        //given
        String name = "test";
        Car car = new Car(name, 0);

        //when
        String result = car.getName();

        //then
        assertThat(result).isEqualTo(name);
    }
}