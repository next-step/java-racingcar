package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarRacingTest {

    CarRacing carRacing;

    @Test
    @DisplayName("차량 위치에 맞게 상태 이미지를 출력한다.")
    public void print_car_state() throws Exception {
        carRacing = new CarRacing();

        assertThat(carRacing.printCarState(3)).isEqualTo("---");
        assertThat(carRacing.printCarState(1)).isEqualTo("-");
        assertThat(carRacing.printCarState(0)).isEqualTo("");
    }

}
