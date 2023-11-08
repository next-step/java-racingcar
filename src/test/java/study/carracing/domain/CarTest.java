package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("random 값이 4이상일 경우 자동차가 1칸 전진한다.")
    void moveCar(int randomValue) {
        Car car = new Car("car1");

        car.move(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("random 값이 4미만일 경우 자동차는 움직이지 않는다.")
    void dontMoveCar(int randomValue) {
        Car car = new Car("car1");

        car.move(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @Test
    @DisplayName("이름이 car1인 자동차의 위치가 2일 때 toString 호출 시 'car1 : --'가 출력된다.")
    void carToString() {
        Car car = new Car("car1");

        car.move(4);

        assertThat(car.toString()).isEqualTo("car1 : --");
    }

    @Test
    @DisplayName("생성자를 통해 position을 주입할 수 있다.")
    void setPosition() {
        Car car = new Car(4, "hyun");

        car.move(5);

        assertThat(car.getPosition()).isEqualTo(5);
    }
}
