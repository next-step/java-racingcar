package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void carPositionShouldBeInitializedByOneTest() {
        assertThat(new Car().getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"2,false", "3,false", "4,true", "5,true", "6,true", "7,true", "8,true"})
    public void carIsMovableWhenRandomLTE4(int random, boolean expected) {
        Car car = new Car();

        boolean actual = car.isMovable(random);
        assertThat(actual).isEqualTo(expected);
    }
}
