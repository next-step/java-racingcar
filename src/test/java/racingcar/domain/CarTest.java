package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.nickname.Nickname;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setData() {
        car = new Car(new Nickname("boost"), new Position(0));
    }

    @Test
    @DisplayName("자동차는 움직일 수 있다.")
    void moveSuccess() {
        car.move(new SuccessCondition());

        assertThat(car).isEqualTo(new Car(new Nickname("boost"), new Position(1)));
    }

    @Test
    @DisplayName("자동차는 움직이지 않을 수 있다.")
    void tryFail() {
        car.move(new FailCondition());

        assertThat(car).isEqualTo(new Car(new Nickname("boost"), new Position(0)));
    }

    @Test
    @DisplayName("자동차를 생성할때 닉네임을 받을 수 있다.")
    void nickname() {
        Car expected = new Car("boost");

        assertThat(car).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차를 생성할때 Nickname 클래스를 받을 수 있다.")
    void nicknameClass() {
        Car car = new Car(new Nickname("boost"), new Position());

        assertThat(this.car).isEqualTo(car);
    }

    @Test
    @DisplayName("인자로 받는 car인스턴스와 같은 position인지 확인할 수 있다.")
    void isSamePosition() {
        Car car = new Car(new Nickname("boost"));

        assertThat(this.car).isEqualTo(car);
    }
}
