package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @DisplayName("4이상일 경우 거리 1 증가")
    @Test
    void move() {
        Car car = new Car("test");
        car.move();
        assertThat(car.getDistance()).isEqualTo(2);
    }


    @Test
    void 생성시_distance() {
        Car car = new Car("test");
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void moveable(){
        Car car = new Car("test");
        assertThat(car.moveable(5)).isTrue();
    }

    @Test
    void carName(){
        Car car = new Car("name");
        assertThat(car.getName()).isEqualTo("name");
    }

    @DisplayName("자동차의 이름은 5글자를 넘을 수 없는지 체크")
    @Test
    void carNameLimit(){
        assertThatThrownBy(()-> new Car("123456")).isInstanceOf(InvalidParameterException.class);
    }
}
