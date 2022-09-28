package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setData() {
        car = createCar();
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

    private Car createCar() {
        String nickname = "boost";
        return new Car(nickname);
    }
}