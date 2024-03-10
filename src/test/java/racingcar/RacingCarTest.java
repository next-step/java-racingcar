package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarTest {
    private static final int ADVANCE_CONDITION_NUMBER = 4;

    @DisplayName("랜덤값이 4 이상일 경우 전진한다.")
    @Test
    public void advancePositionFourOver() {
        //given
        Car car = new Car();
        int random = new Random().nextInt(10);

        //when
        car.move(random);

        //then
        if(random >= ADVANCE_CONDITION_NUMBER) {
            assertThat(car.getPosition()).isEqualTo(1);
            return;
        }
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
