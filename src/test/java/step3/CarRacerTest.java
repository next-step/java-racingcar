package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarRacerTest {

    @DisplayName("카레이서는 자동차의 엑셀을 밟아 0~9사이의 임의의 값을 생성한다.")
    @Test
    void stepOnAccelerator() {
        // given
        CarRacer carRacer = new CarRacer();

        // when & then
        for (int i=0; i<10; i++) {
            int number = carRacer.stepOnAccelerator();
            assertThat(number).isBetween(0, 9);
        }
    }
}
