package domain.racing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest{

    @DisplayName("자동차 이름을 부여한다.")
    @Test
    void carName(){
        Car car = new Car();
        assertThat(car.name("pooh")).isEqualTo("pooh");
    }

    @DisplayName("자동차 이름은 5글자를 초과하면 안된다.")
    @Test
    void isCarNameLength(){
        Car car = new Car();
        assertThat(car.isCarName("kera")).isTrue();
    }

    @DisplayName("자동차 이름은 (,)로 구분한다.")
    @Test
    void cars() {
        Car car = new Car();
        String[] a = {"aaa", "bbb", "ccc"};
//        assertThat(car.cars("aaa,bbb,ccc")).isNull();
    }
    @DisplayName("몇 번 돌릴지 정한다.")
    @Test
    void racingGameCount(){
        Car car = new Car();
//        assertThat(car.gameCount(5)).isEqualTo(5);
    }

    @DisplayName("4이상이면 앞으로 전진")
    @Test
    void moveCar(){
        Car car = new Car();
        assertThat(car.moveCar()).isEqualTo("전진");
    }
}
