package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.MovableMoveStrategy;
import racinggame.domain.NonMovableMoveStrategy;
import racinggame.domain.Trace;
import racinggame.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("차를 생성했을 때, 이름이 맞는지 테스트")
    void constructorTest() {
        Car car = new Car( new Name("붕붕이"));

        assertThat(car.getName()).isEqualTo(new Name("붕붕이"));
        assertThat(car.getTrace()).isEqualTo(new Trace(0));
    }

    @Test
    @DisplayName("차가 random 값이 4보다 크거나 같다면 전진")
    void moveTest_NumberIsEqualOrGreaterThanFour() {
        Car car = new Car( new Name("붕붕이"));

        // given
        Trace initialTrace = car.getTrace();
        Trace traceIfMoved = initialTrace.move();
        MovableMoveStrategy movableMoveStrategy = new MovableMoveStrategy();

        // when
        car.move(movableMoveStrategy);

        // then
        assertThat(car.getTrace()).isEqualTo(traceIfMoved);
    }

    @Test
    @DisplayName("차가 random 값이 4보다 작으면 그대로")
    void moveTest_NumberIsLessThanFour() {
        Car car = new Car( new Name("붕붕이"));

        // given
        Trace initialTrace = car.getTrace();
        NonMovableMoveStrategy nonMovableMoveStrategy = new NonMovableMoveStrategy();

        // when
        car.move(nonMovableMoveStrategy);

        // then
        assertThat(car.getTrace()).isEqualTo(initialTrace);
    }
}
