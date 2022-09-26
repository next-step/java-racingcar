package racing.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.model.Car;
import racing.model.CarPosition;
import racing.model.DefaultCar;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCarMoveStrategyTest {
    @Test
    void 기본차는_이동전략은_default이다() {
        Car car = new DefaultCar();
        car.setStrategy(new DefaultCarMoveStrategy());
        assertThat(car).isEqualTo(new DefaultCar());
    }

    @ParameterizedTest
    @CsvSource(value = {"4,true", "3,false", "5,true"})
    void 기본차의_이동은_랜덤값_4이상이다(int random, boolean isMove) {
        Car car = new DefaultCar();
        car.setStrategy(new DefaultCarMoveStrategy());
        assertThat(car.canMove(random)).isEqualTo(isMove);
    }
}
