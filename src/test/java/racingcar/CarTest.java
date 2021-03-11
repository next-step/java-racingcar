package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.FixedEngine;
import racingcar.domain.RandomEngine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("이름을 가진 자동차를 생성한다")
    @Test
    void createCarTest() {
        Car car = new Car(new RandomEngine(), "name");
        assertThat(car.getPosition()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("name");
    }

    @DisplayName("자동차는 이동한다")
    @Test
    void moveCarTest() {
        Car car = new Car(new FixedEngine(5), "name");
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 이동하지 않는다")
    @Test
    void moveCarTestSecond() {
        Car car = new Car(new FixedEngine(3),"name");
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("이름이 없는 자동차는 만들 수 없다")
    @Test
    void createCarWithoutNameTest() {
        assertThatThrownBy(() ->new Car(new FixedEngine(3), "")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->new Car(new FixedEngine(3), null)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차의 이름은 5자를 넘지 않는다")
    @Test
    void creatCarWithOverFiveLengthTest() {
        assertThatThrownBy(() ->new Car(new FixedEngine(3), "pandahune")).isInstanceOf(IllegalArgumentException.class);
    }
}
