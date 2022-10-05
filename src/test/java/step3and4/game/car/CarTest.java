package step3and4.game.car;

import org.assertj.core.api.SoftAssertions;
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

    @Test
    @DisplayName("자동차의 이름이 5글자를 초과하면 예외가 발생한다.")
    void d() {
        final Car sut = new Car(new Position(1), new Number.Fake(3), new Name("123456"));

        verifyCarNameLengthException(sut).assertAll();
    }

    private SoftAssertions verifyCarNameLengthException(Car sut) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThatThrownBy(() -> sut.toString())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");

        softAssertions.assertThatThrownBy(() -> sut.equals(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");

        softAssertions.assertThatThrownBy(() -> sut.hashCode())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");

        softAssertions.assertThatThrownBy(() -> sut.movedCar())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5글자를 초과할 수 없다.");

        return softAssertions;
    }

}
