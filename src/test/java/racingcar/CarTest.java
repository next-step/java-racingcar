package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {


    @DisplayName("4이상의 수를 받으면 자동차는 움직인다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void test1(int value){
        Car car = new Car();
        car.move(() -> value);

        Assertions.assertThat(car.getState()).isEqualTo(1);
    }

    @DisplayName("4미만의 수를 받으면 자동차는 움직이지 않는다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void test2(int value){
        Car car = new Car();
        car.move(() -> value);

        Assertions.assertThat(car.getState()).isEqualTo(0);
    }
}