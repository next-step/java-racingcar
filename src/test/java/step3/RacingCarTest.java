package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {

    @Test
    @DisplayName("움직였을 때 +1값을 출력한다.")
    void move() {
        RacingCar car = new RacingCar();
        car.move(9);
        int preValue = car.getCurrentPosition();
        assertThat(preValue).isEqualTo(1);
    }
}
