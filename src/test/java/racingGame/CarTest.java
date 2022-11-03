package racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.strategy.*;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 위치 체크")
    void carPosition(){
        Car car = new Car("ab2",2);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("5글자 이상 이름 입력 시 에러 발생")
    void carNameLangthException(){
        assertThatThrownBy(() ->  new Car("5글자초과시에러"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(){
        NumberGenerateStrategy MoveableNumber = new MovableNumberGenerator();
        Car car = new Car();
        car.move(MoveableNumber);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자가 들어오면 정지")
    void carStop(){
        NumberGenerateStrategy nonMoveableNumber = new NonMoveableNumberGenerator();
        Car car = new Car();
        car.move(nonMoveableNumber);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
