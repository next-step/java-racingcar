package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.State;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setup() {
        car = new Car();
    }

    @Test
    @DisplayName("전진 조건이 만족하면 전진 테스트")
    void move() {
        car.increaseState(() -> true);
        assertThat(car.getState().equals(new State(1))).isTrue();
    }

    @Test
    @DisplayName("전진 조건이 만족하지 않으면 멈춤 테스트")
    void stop() {
        car.increaseState(() -> false);
        assertThat(car.getState().equals(new State())).isTrue();
    }

    @Test
    @DisplayName("이름있는 자동차 생성 테스트")
    void createCarWithName() {
        Car car = new Car("jeje");
        assertThat(car.getName()).isEqualTo("jeje");
    }

    @Test
    @DisplayName("자동차 이름이 같다면 동일 객체 테스트")
    void sameNameIsEquals() {
        Car car = new Car("jeje");
        assertThat(car.equals(new Car("jeje"))).isTrue();
    }

    @Test
    @DisplayName("winner인지 아닌지 테스트")
    void isWinner() {
        Car car = new Car("jeje", 10);
        State max = new State(10);
        assertThat(car.isWinner(max)).isTrue();
    }
}
