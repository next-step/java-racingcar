package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private static final String MOVING = "-";

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void moveSuccessTest(int number){
        Car car = new Car();
        car.turn(number);
        assertThat(car.drawPosition()).isEqualTo(MOVING);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void moveFailTest(int number){
        Car car = new Car();
        car.turn(number);
        assertThat(car.drawPosition()).isEqualTo("");
    }
}
