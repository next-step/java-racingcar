package carRacing.domain;

import carRacing.util.GreaterThenThreeMoveStrategy;
import carRacing.util.MoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 객체 관련 테스트")
public class CarTest {

    private static final MoveStrategy MOVE_STRATEGY = new GreaterThenThreeMoveStrategy();
    private static final MovableNumberGenerator MOVABLE_NUMBER_GENERATOR = new MovableNumberGenerator();

    @Test
    @DisplayName("자동차를 한칸 전진시킨다")
    void 자동차_전진_확인() {
        int number = MOVABLE_NUMBER_GENERATOR.generate();

        Car car = new Car("puBao", MOVE_STRATEGY);
        car.move(number);

        assertThat(car.isSamePosition(1)).isTrue();

    }
}
