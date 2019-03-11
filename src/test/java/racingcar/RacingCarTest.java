package racingcar;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @Test
    public void isMoveTrueTest() {
        assertThat(this.racingCar.isMove(new NumberWithParameter(2))).isFalse();
    }

    @Test
    public void isMoveFalseTest() {
        assertThat(this.racingCar.isMove(new NumberWithParameter(8))).isTrue();
    }

}