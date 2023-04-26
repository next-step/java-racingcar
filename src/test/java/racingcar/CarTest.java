package racingcar;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    private MoveStrategy moveStrategyTrue = () -> true;
    private MoveStrategy moveStrategyFalse = () -> false;
    private String carName = "Ayla";
    private String longCarName = "Elizabeth";

    @Test
    @DisplayName("이동 시 위치가 1 증가한다.")
    void move() {
        Car car = new Car(moveStrategyTrue, carName);
        car.tryMove();
        assertThat(car.isAt(1)).isTrue();
    }

    @Test
    @DisplayName("정지 시 위치가 증가하지 않는다.")
    void stay() {
        Car car = new Car(moveStrategyFalse, carName);
        assertThat(car.isAt(0)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 에러가 발생한다.")
    void longCarName() {
        assertThatThrownBy(() -> new Car(new FourOverTenMoveStrategy(), longCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다른 자동차와의 위치를 비교할 수 있다.")
    void compare() {
        Car car1 = new Car(moveStrategyTrue, carName);
        Car car2 = new Car(moveStrategyFalse, carName);
        car1.tryMove();
        assertThat(car1.compareTo(car2)).isEqualTo(1);
    }

    @Test
    @DisplayName("현재 자동차의 위치를 확인할 수 있다.")
    void equal() {
        Car car = new Car(moveStrategyTrue, carName);
        assertThat(car.isAt(0)).isTrue();
    }
}
