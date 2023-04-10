package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("car 객체를 생성한다.")
    @Test
    void createCar() {
        Car car = Car.create();

        assertThat(car).isNotNull();
    }

    @DisplayName("car객체의 moveCount값을 1 증가시킨다.")
    @Test
    void increaseMoveCount() {
        Car car = Car.create();
        car.increaseMoveCount();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("4이상인 랜덤값이 주어진 true를 리턴하고 4미만 랜덤값이 주어지면 false를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "4:true", "5:true", "5:true"}, delimiter = ':')
    void canMove(int value, boolean expected) {
        Car car = Car.create();

        assertThat(car.canMove(value)).isEqualTo(expected);
    }

    @DisplayName("4이상인 랜덤값이 주어지면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void move1(int randomNumber) {
        Car car = Car.create();

        car.move(randomNumber);

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("4미만인 랜덤값이 주어지면 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void move2(int randomNumber) {
        Car car = Car.create();

        car.move(randomNumber);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}
