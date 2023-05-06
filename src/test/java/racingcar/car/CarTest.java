package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;


class CarTest {


    @DisplayName("4이상의 수를 받으면 자동차는 움직인다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void test1(int value){
        Car car = Car.from("a");
        car.move(() -> value);

        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("4미만의 수를 받으면 자동차는 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void test2(int value){
        Car car = Car.from("a");
        car.move(() -> value);

        Assertions.assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차에 이름을 부여할 수 있다")
    @Test
    public void test3(){
        String name = "name";

        Car car = Car.from(name);

        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름 null 또는 blank가 아니어야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    public void test4(String name){
        Assertions.assertThatThrownBy(() -> Car.from(name)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("자동차 이름은 5자를 초과하면 안된다")
    @Test
    public void test5(){
        String name = "555556";
        Assertions.assertThatThrownBy(() -> Car.from(name)).isInstanceOf(RuntimeException.class);
    }

}