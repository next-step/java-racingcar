package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    @DisplayName("자동차 이름이 5자 이하일 때 유효성 검사를 통과하는지 확인")
    void validateName_5자이하() {
        assertThatCode(() -> new Car("valid")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과할 때 예외를 던지는지 확인")
    void validateName_5자초과() {
        assertThatThrownBy(() -> new Car("invalid")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차가 우승자인지 확인")
    void isWinnerWhenDistanceIsMax() {
        Car car = new Car("win");
        car.move(true);
        assertThat(car.isWinner(1)).isTrue();
    }

    @Test
    @DisplayName("자동차가 우승자가 아닌지 확인")
    void isNotWinnerWhenDistanceIsNotMax() {
        Car car = new Car("lose");
        car.move(true);
        assertThat(car.isWinner(2)).isFalse();
    }


    @Test
    @DisplayName("자동차가 이동하는지 확인")
    void move() {
        Car car = new Car("truck");
        boolean isMove = true;
        car.move(isMove);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
