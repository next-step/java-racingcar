package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    @Test
    @DisplayName("차를 생성했을 때, 이름이 맞는지 테스트")
    void constructorTest() {
        Car car = new Car("붕붕이");

        assertThat(car.getName()).isEqualTo("붕붕이");
        assertThat(car.getTrace()).isEqualTo(0);
    }

    @Test
    @DisplayName("차가 random 값이 4보다 크거나 같다면 전진")
    void moveTest_NumberIsEqualOrGreaterThanFour() {
        Car car = new Car("붕붕이");

        // given
        int initialTrace = car.getTrace();
        int traceIfMoved = initialTrace + 1;
        MovableMoveStrategy movableMoveStrategy = new MovableMoveStrategy();

        // when
        car.move(movableMoveStrategy);

        // then
        assertThat(car.getTrace()).isEqualTo(traceIfMoved);
    }

    @Test
    @DisplayName("차가 random 값이 4보다 작으면 그대로")
    void moveTest_NumberIsLessThanFour() {
        Car car = new Car("붕붕이");

        // given
        int initialTrace = car.getTrace();
        NonMovableMoveStrategy nonMovableMoveStrategy = new NonMovableMoveStrategy();

        // when
        car.move(nonMovableMoveStrategy);

        // then
        assertThat(car.getTrace()).isEqualTo(initialTrace);
    }
}
