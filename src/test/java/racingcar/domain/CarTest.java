package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static final String CAR_NAME = "edge";
    private static MoveState moveState;

    @BeforeAll
    static void setUp() {
        moveState = () -> true;
    }

    @DisplayName("한번 이동하면 score가 1 올라가야한다.")
    @Test
    void go() {
        Car car = new Car(CAR_NAME);
        car.go(moveState);
        assertThat(car.getScore()).isEqualTo(1);
    }

    @DisplayName("car의 현재 스코어와 숫자가 같은지 비교한다.")
    @Test
    void isSameNumber() {
        Car car = new Car("test");
        assertThat(car.isSameNumber(0)).isTrue();
        car.go(() -> true);
        assertThat(car.isSameNumber(1)).isTrue();
    }
}
