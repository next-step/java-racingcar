package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    public void carPositionShouldBeInitializedByOneTest() {
        assertThat(new Car("TEST").getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "4,true"}) // 경계를 두고 전후만 테스트 해보자
    public void carIsMovableWhenRandomLTE4(int random, boolean expected) {
        Car car = new Car("TEST");

        boolean actual = car.isMovable(random);
        assertThat(actual).isEqualTo(expected);
    }


}
