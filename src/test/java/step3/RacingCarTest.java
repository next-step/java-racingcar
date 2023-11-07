package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이동 여부를 결정하는 random 값은 0에서 9사이이다.")
    void carMoveException() {
        // given
        RacingCar car = new RacingCar();

        // when
        int randomInt = car.getRandomInt();

        // then
        assertThat(randomInt).isLessThan(10);
        assertThat(randomInt).isGreaterThan(-1);
    }

    @Test
    @DisplayName("random 값이 4이상 9이하일 경우, 자동차는 이동한다.")
    void move() {
        // given
        RacingCar car = new RacingCar();
        int randomInt = 8;

        // when
        car.move(randomInt);

        // then
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
