package racingcar.domain.car;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("자동차는 난수 값에 의해 정확하게 제어된다.")
class MoveTest {
    @DisplayName("랜덤 값 4 이상은 앞으로 전진한다")
    @Test
    void move() {
        //given
        Car oldCar = Car.of("jason", 5);

        //when
        Car newCar = Move.isSatisfiedMoveCondition(oldCar, 4);

        //then
        Assertions.assertThat(newCar).isNotEqualTo(oldCar);
    }

    @DisplayName("랜덤 값 4 미만은 전지하지 않는다.")
    @Test
    void notMove() {
        //given
        Car oldCar = Car.of("jason", 5);

        //when
        Car newCar = Move.isSatisfiedMoveCondition(oldCar, 3);

        //then
        Assertions.assertThat(newCar).isEqualTo(oldCar);
    }
}