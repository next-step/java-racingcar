package step3and4and5.game.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3and4and5.client.number.Number;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("숫자가 4이상 나올 경우 자동차는 한 칸 전진한다.")
    void a() {
        final Number number = new Number.Fake(4);
        final Car sut = new Car.Factory(number, new Position(0), "1").car();

        assertThat(sut.movedCar()).isEqualTo(new Car.Factory(number, new Position(1), "1").car());
    }

    @Test
    @DisplayName("숫자가 4미만 나올 경우 자동차는 현재 위치에 움직이지 않는다.")
    void b() {
        final Number number = new Number.Fake(3);
        final Car sut = new Car.Factory(number, new Position(0), "1").car();

        assertThat(sut.movedCar()).isEqualTo(new Car.Factory(number, new Position(0), "1").car());
    }

    @Test
    @DisplayName("자동차를 출력할 수 있다.")
    void c() {
        final Car sut = new Car.Factory(new Number.Fake(3), new Position(1), "12345").car();

        assertThat(sut.print()).isEqualTo("12345 : -");
    }

}
