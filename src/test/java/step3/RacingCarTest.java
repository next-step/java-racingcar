package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingCarTest {

    @Test
    @DisplayName("power가 4이상 일 때 +1 값을 출력한다.")
    public void moveOverPower() {
        RacingCar car = new RacingCar("pobi");
        car.move(4);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("power가 4잇아이 아닐 때 +0 값을 출력한다.")
    public void moveNotOverPower() {
        RacingCar car = new RacingCar("pobi");
        car.move(3);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }
}
