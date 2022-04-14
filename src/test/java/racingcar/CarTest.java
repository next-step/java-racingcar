package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Car 클래스 테스트")
public class CarTest {

    @Test
    @DisplayName("Car 생성시 state 로 null 이 들어오면 오류가 발생한다.")
    void carNullTest() {
        assertThatThrownBy(()-> new Car(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("state is null");
    }

    @Test
    @DisplayName("자동차의 초기 상태는 0이어야 한다.")
    void carStateTest() {
        Car car = new Car();

        assertThat(car.state()).isEqualTo(PositiveInteger.ZERO);
    }

    @Test
    @DisplayName("자동차가 movable 하다면 한칸 전진한다.")
    void movableTest() {
        Car car = new Car();

        Car nextCar = car.move(() -> true);

        assertThat(nextCar.state()).isEqualTo(PositiveInteger.add(car.state(), new PositiveInteger(1)));
    }

    @Test
    @DisplayName("자동차가 unmovable 하다면 멈춰있는다.")
    void unmovableTest() {
        Car car = new Car();

        Car nextCar = car.move(() -> false);

        assertThat(nextCar.state()).isEqualTo(car.state());
    }
}
