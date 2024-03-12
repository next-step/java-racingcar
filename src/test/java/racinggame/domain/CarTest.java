package racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("도메인 객체 Car 테스트")
public class CarTest {

    private Car car;

    @BeforeEach
    void initCar() {
        car = new Car(new CarName("자동차"));
    }

    @Test
    public void 생성자_초기위치_0() {
        assertThat(car.position()).isEqualTo(new Position());
    }

    @Test
    public void 주행() {
        car.run(new AlwaysMoveCondition());

        assertThat(car.position()).isEqualTo(new Position(1));
    }

    @Test
    public void 정지() {
        car.run(new NeverMoveCondition());

        assertThat(car.position()).isEqualTo(new Position());
    }
}
