package racing.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultCarMoveStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"4,true", "3,false", "5,true"})
    void 기본차의_이동은_랜덤값_4이상이다(int input, boolean isMove) {
        Car car = new Car("test");
        assertThat(car.canMove(input)).isEqualTo(isMove);
    }
}
