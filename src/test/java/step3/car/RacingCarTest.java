package step3.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.number.Number;
import step3.number.Number.Fake;
import step3.position.CarPosition;

class RacingCarTest {

    @Test
    @DisplayName("숫자가 4이상 나올 경우 자동차는 한 칸 전진한다.")
    void a() {
        final Number number = new Fake(4);
        final RacingCar sut = new RacingCar(number);

        Assertions.assertThat(sut.movedCar()).isEqualTo(new RacingCar(new CarPosition(1), number));
    }

    @Test
    @DisplayName("숫자가 4미만 나올 경우 자동차는 현재 위치에 움직이지 않는다.")
    void b() {
        final Number number = new Fake(3);
        final RacingCar sut = new RacingCar(number);

        Assertions.assertThat(sut.movedCar()).isEqualTo(new RacingCar(new CarPosition(0), number));
    }

}

