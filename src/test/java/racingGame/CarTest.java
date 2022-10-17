package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingGame.domain.Car;
import racingGame.strategy.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("4이상의 숫자가 들어오면 전진")
    void carMove(){
        MoveStrategy moveStrategy = new MoveAbleStrategy();
        NumberGenerateStrategy MoveableNumber = new MovableNumberGenerator();
        Car car = new Car();
        car.move(moveStrategy,MoveableNumber);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("4미만의 숫자가 들어오면 정지")
    void carStop(){
        MoveStrategy moveStrategy = new MoveAbleStrategy();
        NumberGenerateStrategy nonMoveableNumber = new NonMoveableNumberGenerator();
        Car car = new Car();
        car.move(moveStrategy,nonMoveableNumber);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }
}
