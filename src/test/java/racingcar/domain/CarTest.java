package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @DisplayName("자동차 이름이 5자를 초과하는 경우")
    @Test
    public void exceedFiveCharacter() {
        assertThatExceptionOfType(RuntimeException.class)
          .isThrownBy(() -> new Car("overFive"));
    }

    @DisplayName("난수가 3일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsThree() {
        Car car = new Car("mizz");
        car.raceOneTime(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("난수가 4일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFour() {
        Car car = new Car("mizz");
        car.raceOneTime(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("난수가 4일때 배열의 숫자가 증가하는지 확인한다")
    @Test
    public void checkWhenRandomNumberIsFive() {
        Car car = new Car("mizz");
        car.raceOneTime(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void comparePosition() {
        Car car = new Car("mizz");
        for (int i = 0; i < 4; i++) {
            car.raceOneTime(4);
        }
        assertThat(car.comparePosition(3)).isEqualTo(4);
        assertThat(car.comparePosition(4)).isEqualTo(4);
        assertThat(car.comparePosition(5)).isEqualTo(5);
    }

    @Test
    public void isSamePosition() {
        Car car = new Car("mizz");
        assertThat(car.isSamePosition(0)).isTrue();
        car.raceOneTime(4);
        assertThat(car.isSamePosition(1)).isTrue();
    }
}