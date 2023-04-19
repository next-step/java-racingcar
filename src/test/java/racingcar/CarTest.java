package racingcar;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 시 위치가 증가하지 않는다.")
    void stay() {
        Car car = new Car(moveStrategyFalse, carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 에러가 발생한다.")
    void longCarName() {
        assertThatThrownBy(() -> new Car(new FourOverTenMoveStrategy(), longCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
