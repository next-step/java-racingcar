package step3.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.number.Number;
import step3.position.Position;

class CarTest {

    @Test
    @DisplayName("숫자가 4이상 나올 경우 자동차는 한 칸 전진한다.")
    void a() {
        final Number number = new Number.Fake(4);
        final Car sut = new Car(number);

        Assertions.assertThat(sut.movedCar()).isEqualTo(new Car(new Position(1), number));
    }

    @Test
    @DisplayName("숫자가 4미만 나올 경우 자동차는 현재 위치에 움직이지 않는다.")
    void b() {
        final Number number = new Number.Fake(3);
        final Car sut = new Car(number);

        Assertions.assertThat(sut.movedCar()).isEqualTo(new Car(new Position(0), number));
    }

}

