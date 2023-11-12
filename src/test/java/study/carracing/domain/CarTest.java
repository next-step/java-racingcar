package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carracing.fake.TestMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("이름이 car1인 자동차의 위치가 2일 때 toString 호출 시 'car1 : --'가 출력된다.")
    void carToString() {
        Car car = new Car(new Name("car1"));

        car.move(new TestMoveStrategy(true));

        assertThat(car.toString()).isEqualTo("car1 : --");
    }

    @Test
    @DisplayName("생성자를 통해 position을 주입할 수 있다.")
    void setPosition() {
        Car car = new Car(new Position(4), new Name("car1"));

        car.move(new TestMoveStrategy(true));

        assertThat(car.getPosition()).isEqualTo(5);
    }
}
