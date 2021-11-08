package racingcar;

import calculator.Calculator;
import calculator.exception.NotSupportedOperatorException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.TooLongCarNameException;
import racingcar.strategy.MoveStrategy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {

    static public class TestMoveStrategy implements MoveStrategy {

        @Override
        public boolean strategicMove() {
            return true;
        }
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름은 5자를 넘을 경우 TooLongCarNameException 예외가 발생한다.")
    public void 테스트_constructor_TooLongCarNameException() {

        assertThrows(TooLongCarNameException.class, () -> new Car("123456",
                new TestMoveStrategy()));
    }

    @Test
    @DisplayName("move 메소드는 자동차를 이동시키고 현재 위치를 반환한다")
    public void 테스트_Car_move() {

        Car car = new Car("", new TestMoveStrategy());
        assertThat(car.move().getPosition()).isEqualTo(1);
        assertThat(car.move().getPosition()).isEqualTo(2);
        assertThat(car.move().getPosition()).isEqualTo(3);
        assertThat(car.move().getPosition()).isEqualTo(4);
    }
}