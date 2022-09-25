package step3.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.number.Number;
import step3.number.Number.Fake;

class RacingCarTest {

    @Test
    @DisplayName("숫자가 4이상 나올 경우 자동차는 한 칸 전진한다.")
    void a() {
        final Number number = new Fake(4);
        final Car sut = new RacingCar(number);

        sut.useTurn();

        Assertions.assertThat(sut).isEqualTo(new RacingCar(1, number));
    }

}
