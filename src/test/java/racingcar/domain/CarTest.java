package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("5글자 미만 이름을 갖는 car 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "crong", "honux"})
    void successCreateCar(String value) {
        Car car = Car.create(value);

        assertThat(car).isNotNull();
        assertThat(car.getName()).isEqualTo(value);
    }

    @DisplayName("5글자 초과하는 이름을 갖는 car 객체를 생성할때 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobiii", "cronggg", "honuxxxx"})
    void failCreateCar(String value) {
        assertThatThrownBy(() ->Car.create(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("car객체의 moveCount값을 1 증가시킨다.")
    @Test
    void increaseMoveCount() {
        Car car = Car.create("pobi");
        car.increaseMoveCount();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("4이상인 랜덤값이 주어진 true를 리턴하고 4미만 랜덤값이 주어지면 false를 리턴한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "4:true", "5:true", "5:true"}, delimiter = ':')
    void canMove(int value, boolean expected) {
        Car car = Car.create("pobi");

        assertThat(car.canMove(value)).isEqualTo(expected);
    }

    @DisplayName("4이상인 랜덤값이 주어지면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void move1(int randomNumber) {
        Car car = Car.create("pobi");

        car.move(randomNumber);

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("4미만인 랜덤값이 주어지면 멈춘다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void move2(int randomNumber) {
        Car car = Car.create("pobi");

        car.move(randomNumber);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}
