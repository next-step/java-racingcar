package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.nickname.Nickname;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setData() {
        car = new Car("boost");
    }

    @Test
    @DisplayName("자동차는 움직일 수 있다.")
    void move() {
        car.move(new GoodCondition());

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 움직이지 않을 수 있다.")
    void tryMove() {
        car.move(new BadCondition());

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차를 생성할때 닉네임을 받을 수 있다.")
    void nickname() {
        String expected = "boost";

        assertThat(car.getName()).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차를 생성할때 Nickname 클래스를 받을 수 있다.")
    void nickname_arg() {
        Car car = new Car(new Nickname("boost"));

        assertThat(this.car).isEqualTo(car);
    }
}
