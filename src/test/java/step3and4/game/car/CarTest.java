package step3and4.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4.client.number.Number;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("숫자가 4이상 나올 경우 자동차는 한 칸 전진한다.")
    void a() {
        final Number number = new Number.Fake(4);
        final Car sut = new Car(number);

        assertThat(sut.movedCar()).isEqualTo(new Car(new Position(1), number));
    }

    @Test
    @DisplayName("숫자가 4미만 나올 경우 자동차는 현재 위치에 움직이지 않는다.")
    void b() {
        final Number number = new Number.Fake(3);
        final Car sut = new Car(number);

        assertThat(sut.movedCar()).isEqualTo(new Car(new Position(0), number));
    }

    @Test
    @DisplayName("자동차를 출력할 수 있다.")
    void c() {
        final Car sut = new Car(new Position(1), new Number.Fake(3), new Name("12345"));

        assertThat(sut).hasToString("12345 : -");
    }

}

